package businessLogic.tests;

import businessLogic.model.TicketModel;
import businessLogic.services.TicketService;
import org.junit.Test;

public class TicketServiceTest {

    @Test
    public void create() throws Exception {
        TicketService ticketService = new TicketService();

        final int SHOW_ID = 2;

        int sizeBefore = ticketService.getAllByShowid(SHOW_ID).size();

        TicketModel ticketModel = new TicketModel();

        ticketModel.setIdshow(SHOW_ID);
        ticketModel.setRowNb(8);
        ticketModel.setSeatNb(8);
        ticketModel.setOnName("Junit");

        ticketService.create(ticketModel);

        int sizeAfter = ticketService.getAllByShowid(SHOW_ID).size();

        assert(sizeBefore == sizeAfter);
    }
}
