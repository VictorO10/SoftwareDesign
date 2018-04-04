import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerSimpleComponent implements SimpleComponent {
  private DaggerSimpleComponent(Builder builder) {}

  public static Builder builder() {
    return new Builder();
  }

  public static SimpleComponent create() {
    return new Builder().build();
  }

  @Override
  public void inject(Application application) {}

  public static final class Builder {
    private Builder() {}

    public SimpleComponent build() {
      return new DaggerSimpleComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This
     *     method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder simpleModule(SimpleModule simpleModule) {
      Preconditions.checkNotNull(simpleModule);
      return this;
    }
  }
}
