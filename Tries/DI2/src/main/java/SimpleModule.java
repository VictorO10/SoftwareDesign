import dagger.Provides;

@dagger.Module
public class SimpleModule {

    @Provides
    Service provideService(){
        return new Service();
    }
}
