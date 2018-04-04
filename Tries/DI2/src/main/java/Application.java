import javax.inject.Inject;

public class Application {

    private SimpleComponent component;

     Service service;

    @Inject
    public Application(Service service){
        this.service = service;
    }

    public void run(){
        System.out.println("Application start");
        service.doWork();
        System.out.println("Application end.");
    }
}
