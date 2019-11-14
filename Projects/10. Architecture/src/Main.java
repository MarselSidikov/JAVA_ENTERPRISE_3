import ru.itis.context.ApplicationContext;
import ru.itis.context.ApplicationContextReflectionBased;
import ru.itis.dispatcher.RequestsDispatcher;
import ru.itis.services.SignInService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContextReflectionBased();
        SignInService service = context.getComponent(SignInService.class, "signInService");
        RequestsDispatcher dispatcher = new RequestsDispatcher(service);
    }
}
