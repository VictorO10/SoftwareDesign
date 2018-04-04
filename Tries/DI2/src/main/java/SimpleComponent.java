import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { SimpleModule.class})
public interface SimpleComponent {
    void inject(Application application);
}
