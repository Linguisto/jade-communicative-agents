package my.app;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class MainController {

    private int counter = 0;

    void initAgents() {
        // Retrieve the singleton instance of the JADE Runtime
        Runtime rt = Runtime.instance();
        //Create a container to host the Default Agent
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.MAIN_PORT, "8080");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc = rt.createMainContainer(p);
        try {
            AgentController BookBuyerAgentController = cc.createNewAgent
                    (Integer.toString(++counter), "my.app.agents.BookBuyerAgent", null);
            BookBuyerAgentController.start();

            AgentController BookSellerAgentController = cc.createNewAgent
                    (Integer.toString(++counter), "my.app.agents.BookSellerAgent", null);
            BookSellerAgentController.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
