import dagger.Component;

@Component(modules = {UserServiceProvider.class})
public interface UserServiceComponent {

    void provideUserService(AppA appA);

    void provideUserService(AppB appB);
}
