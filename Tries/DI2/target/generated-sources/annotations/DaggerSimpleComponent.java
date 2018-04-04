import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerSimpleComponent implements SimpleComponent {
  private SimpleModule simpleModule;

  private DaggerSimpleComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static SimpleComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.simpleModule = builder.simpleModule;
  }

  @Override
  public void inject(Application application) {
    injectApplication(application);
  }

  private Application injectApplication(Application instance) {
    Application_MembersInjector.injectService(
        instance,
        Preconditions.checkNotNull(
            simpleModule.provideService(),
            "Cannot return null from a non-@Nullable @Provides method"));
    return instance;
  }

  public static final class Builder {
    private SimpleModule simpleModule;

    private Builder() {}

    public SimpleComponent build() {
      if (simpleModule == null) {
        this.simpleModule = new SimpleModule();
      }
      return new DaggerSimpleComponent(this);
    }

    public Builder simpleModule(SimpleModule simpleModule) {
      this.simpleModule = Preconditions.checkNotNull(simpleModule);
      return this;
    }
  }
}
