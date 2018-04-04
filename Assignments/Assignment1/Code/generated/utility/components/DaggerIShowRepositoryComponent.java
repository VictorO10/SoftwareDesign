package utility.components;

import businessLogic.services.ShowService;
import businessLogic.services.ShowService_MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import utility.providers.ShowRepositoryProvider;
import utility.providers.ShowRepositoryProvider_GetIShowRepositoryFactory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerIShowRepositoryComponent implements IShowRepositoryComponent {
  private ShowRepositoryProvider showRepositoryProvider;

  private DaggerIShowRepositoryComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static IShowRepositoryComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.showRepositoryProvider = builder.showRepositoryProvider;
  }

  @Override
  public void provideShowRepository(ShowService showService) {
    injectShowService(showService);
  }

  private ShowService injectShowService(ShowService instance) {
    ShowService_MembersInjector.injectSetIShowRepository(
        instance,
        Preconditions.checkNotNull(
            ShowRepositoryProvider_GetIShowRepositoryFactory.proxyGetIShowRepository(
                showRepositoryProvider),
            "Cannot return null from a non-@Nullable @Provides method"));
    return instance;
  }

  public static final class Builder {
    private ShowRepositoryProvider showRepositoryProvider;

    private Builder() {}

    public IShowRepositoryComponent build() {
      if (showRepositoryProvider == null) {
        this.showRepositoryProvider = new ShowRepositoryProvider();
      }
      return new DaggerIShowRepositoryComponent(this);
    }

    public Builder showRepositoryProvider(ShowRepositoryProvider showRepositoryProvider) {
      this.showRepositoryProvider = Preconditions.checkNotNull(showRepositoryProvider);
      return this;
    }
  }
}
