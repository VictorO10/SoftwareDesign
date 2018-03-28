package businessLogic.utility.factoryMethod;

import businessLogic.model.TicketModel;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import java.util.List;

public class XMLExportAlgorithm implements ExportAlgorithm {

    @Override
    public void export(List<TicketModel> tickets) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("tickets");
            doc.appendChild(rootElement);

            for(TicketModel ticket: tickets) {
                // staff elements
                Element staff = doc.createElement("Ticket");
                rootElement.appendChild(staff);

                // set attribute to staff element
                Attr attr = doc.createAttribute("idticket");
                attr.setValue(Integer.toString(ticket.getIdticket()));
                staff.setAttributeNode(attr);

                // shorten way
                // staff.setAttribute("id", "1");

                // firstname elements
                Element firstname = doc.createElement("idshow");
                firstname.appendChild(doc.createTextNode(Integer.toString(ticket.getIdshow())));
                staff.appendChild(firstname);

                // lastname elements
                Element lastname = doc.createElement("seatNb");
                lastname.appendChild(doc.createTextNode(Integer.toString(ticket.getSeatNb())));
                staff.appendChild(lastname);

                // nickname elements
                Element nickname = doc.createElement("rowNb");
                nickname.appendChild(doc.createTextNode(Integer.toString(ticket.getRowNb())));
                staff.appendChild(nickname);

                // salary elements
                Element salary = doc.createElement("onName");
                salary.appendChild(doc.createTextNode(ticket.getOnName()));
                staff.appendChild(salary);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("tickets.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("XML file saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
