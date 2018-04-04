package utility.components;

import businessLogic.services.TicketService;
import dagger.Component;
import utility.providers.TicketRepositoryProvider;

@Component(modules = {TicketRepositoryProvider.class})
public interface ITicketRepositoryComponent {

    void provideTicketRepository(TicketService ticketService);
}
