package utility.providers;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dataAccess.contracts.ITicketRepository;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TicketRepositoryProvider_GetITicketRepositoryFactory
    implements Factory<ITicketRepository> {
  private final TicketRepositoryProvider module;

  public TicketRepositoryProvider_GetITicketRepositoryFactory(TicketRepositoryProvider module) {
    this.module = module;
  }

  @Override
  public ITicketRepository get() {
    return Preconditions.checkNotNull(
        module.getITicketRepository(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ITicketRepository> create(TicketRepositoryProvider module) {
    return new TicketRepositoryProvider_GetITicketRepositoryFactory(module);
  }

  public static ITicketRepository proxyGetITicketRepository(TicketRepositoryProvider instance) {
    return instance.getITicketRepository();
  }
}
