package businessLogic.utility.factoryMethod;

import businessLogic.model.TicketModel;

import java.util.List;

public interface ExportAlgorithm {
    public void export(List<TicketModel> tickets);
}
