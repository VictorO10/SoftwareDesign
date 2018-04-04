import javax.inject.Inject;

public class appCreator {

    @Inject Application app;

    Application getApp(){
        return app;
    }
}
