import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SimpleModule_ProvideServiceFactory implements Factory<Service> {
  private final SimpleModule module;

  public SimpleModule_ProvideServiceFactory(SimpleModule module) {
    this.module = module;
  }

  @Override
  public Service get() {
    return Preconditions.checkNotNull(
        module.provideService(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Service> create(SimpleModule module) {
    return new SimpleModule_ProvideServiceFactory(module);
  }

  public static Service proxyProvideService(SimpleModule instance) {
    return instance.provideService();
  }
}
