package utility.providers;

import dagger.Module;
import dagger.Provides;
import businessLogic.contractsDAO.ITicketRepository;
import dataAccess.repositories.TicketRepository;

@Module
public class TicketRepositoryProvider {

    @Provides
    ITicketRepository getITicketRepository(){
        return new TicketRepository();
    }
}
