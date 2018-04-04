package businessLogic.services;

import dagger.MembersInjector;
import dataAccess.contracts.ITicketRepository;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TicketService_MembersInjector implements MembersInjector<TicketService> {
  private final Provider<ITicketRepository> ticketRepositoryProvider;

  public TicketService_MembersInjector(Provider<ITicketRepository> ticketRepositoryProvider) {
    this.ticketRepositoryProvider = ticketRepositoryProvider;
  }

  public static MembersInjector<TicketService> create(
      Provider<ITicketRepository> ticketRepositoryProvider) {
    return new TicketService_MembersInjector(ticketRepositoryProvider);
  }

  @Override
  public void injectMembers(TicketService instance) {
    injectSetITicketRepository(instance, ticketRepositoryProvider.get());
  }

  public static void injectSetITicketRepository(
      TicketService instance, ITicketRepository ticketRepository) {
    instance.setITicketRepository(ticketRepository);
  }
}
