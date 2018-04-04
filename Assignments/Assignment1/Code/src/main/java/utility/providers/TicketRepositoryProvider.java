package utility.providers;

import dagger.Module;
import dagger.Provides;
import dataAccess.contracts.ITicketRepository;
import dataAccess.repositories.TicketRepository;

@Module
public class TicketRepositoryProvider {

    @Provides
    ITicketRepository getITicketRepository(){
        return new TicketRepository();
    }
}
