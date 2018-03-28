package businessLogic.utility.factoryMethod;

import businessLogic.model.TicketModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class CSVExportAlgorithm implements ExportAlgorithm {

    @Override
    public void export(List<TicketModel> tickets) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("tickets.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("idticket");
        sb.append(',');
        sb.append("idshow");
        sb.append(',');
        sb.append("seatNb");
        sb.append(',');
        sb.append("rowNb");
        sb.append(',');
        sb.append("onName");
        sb.append('\n');

        for(TicketModel ticket: tickets) {
            sb.append(ticket.getIdticket());
            sb.append(',');
            sb.append(ticket.getIdshow());
            sb.append(',');
            sb.append(ticket.getSeatNb());
            sb.append(',');
            sb.append(ticket.getRowNb());
            sb.append(',');
            sb.append(ticket.getOnName());
            sb.append('\n');
        }

        pw.write(sb.toString());
        pw.close();
    }
}
