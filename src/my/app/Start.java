package my.app;

// Class to start application.
public class Start {
    public static void main(String... args) {
        MainController controller = new MainController();
        controller.initAgents();
    }
}
