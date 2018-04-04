package utility.providers;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dataAccess.contracts.IShowRepository;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ShowRepositoryProvider_GetIShowRepositoryFactory
    implements Factory<IShowRepository> {
  private final ShowRepositoryProvider module;

  public ShowRepositoryProvider_GetIShowRepositoryFactory(ShowRepositoryProvider module) {
    this.module = module;
  }

  @Override
  public IShowRepository get() {
    return Preconditions.checkNotNull(
        module.getIShowRepository(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<IShowRepository> create(ShowRepositoryProvider module) {
    return new ShowRepositoryProvider_GetIShowRepositoryFactory(module);
  }

  public static IShowRepository proxyGetIShowRepository(ShowRepositoryProvider instance) {
    return instance.getIShowRepository();
  }
}
