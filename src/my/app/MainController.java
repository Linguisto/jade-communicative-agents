package my.app;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

class MainController {

    private int counter = 0;

    void initAgents() {
        PropertyHandler propertyHandler = new PropertyHandler();
        // Retrieve the singleton instance of the JADE Runtime
        Runtime runtime = Runtime.instance();
        //Create a container to host the Default Agent
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST, propertyHandler.read("settings.properties").getProperty("host"));
        profile.setParameter(Profile.MAIN_PORT, propertyHandler.read("settings.properties").getProperty("port"));
        profile.setParameter(Profile.GUI, "true");

        ContainerController containerController = runtime.createMainContainer(profile);
        try {
            AgentController BookBuyerAgentController = containerController.createNewAgent
                    (Integer.toString(++counter), "my.app.agents.BookBuyerAgent", null);
            BookBuyerAgentController.start();

            AgentController BookSellerAgentController = containerController.createNewAgent
                    (Integer.toString(++counter), "my.app.agents.BookSellerAgent", null);
            BookSellerAgentController.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
