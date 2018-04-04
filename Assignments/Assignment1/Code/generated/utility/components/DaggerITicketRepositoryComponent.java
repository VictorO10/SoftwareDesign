package utility.components;

import businessLogic.services.TicketService;
import businessLogic.services.TicketService_MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import utility.providers.TicketRepositoryProvider;
import utility.providers.TicketRepositoryProvider_GetITicketRepositoryFactory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerITicketRepositoryComponent implements ITicketRepositoryComponent {
  private TicketRepositoryProvider ticketRepositoryProvider;

  private DaggerITicketRepositoryComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ITicketRepositoryComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.ticketRepositoryProvider = builder.ticketRepositoryProvider;
  }

  @Override
  public void provideTicketRepository(TicketService ticketService) {
    injectTicketService(ticketService);
  }

  private TicketService injectTicketService(TicketService instance) {
    TicketService_MembersInjector.injectSetITicketRepository(
        instance,
        Preconditions.checkNotNull(
            TicketRepositoryProvider_GetITicketRepositoryFactory.proxyGetITicketRepository(
                ticketRepositoryProvider),
            "Cannot return null from a non-@Nullable @Provides method"));
    return instance;
  }

  public static final class Builder {
    private TicketRepositoryProvider ticketRepositoryProvider;

    private Builder() {}

    public ITicketRepositoryComponent build() {
      if (ticketRepositoryProvider == null) {
        this.ticketRepositoryProvider = new TicketRepositoryProvider();
      }
      return new DaggerITicketRepositoryComponent(this);
    }

    public Builder ticketRepositoryProvider(TicketRepositoryProvider ticketRepositoryProvider) {
      this.ticketRepositoryProvider = Preconditions.checkNotNull(ticketRepositoryProvider);
      return this;
    }
  }
}
