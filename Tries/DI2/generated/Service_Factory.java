import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Service_Factory implements Factory<Service> {
  private static final Service_Factory INSTANCE = new Service_Factory();

  @Override
  public Service get() {
    return new Service();
  }

  public static Factory<Service> create() {
    return INSTANCE;
  }
}
