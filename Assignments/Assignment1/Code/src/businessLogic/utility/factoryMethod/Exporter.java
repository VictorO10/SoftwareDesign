package businessLogic.utility.factoryMethod;

import businessLogic.model.TicketModel;

import java.util.List;

public abstract class Exporter {

    public void writeToDisk(List<TicketModel> tickets) {
        ExportAlgorithm exportAlgorithm = getExportAlgorithm();

        exportAlgorithm.export(tickets);
    }

    public abstract ExportAlgorithm getExportAlgorithm();

}
