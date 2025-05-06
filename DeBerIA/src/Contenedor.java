import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class Contenedor {
    public void contenedor (){
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        AgentContainer agentContainer = runtime.createMainContainer(profile);
        agregarAgentes(agentContainer);
    }

    private void agregarAgentes(AgentContainer agentContainer) {
        
        try {
            agentContainer.createNewAgent("Agente5", Agente5.class.getName(), new Object[]{agentContainer,0}).start();
            agentContainer.createNewAgent("Agente4", Agente4.class.getName(), null).start();
            agentContainer.createNewAgent("Agente3", Agente3.class.getName(), null).start();
            agentContainer.createNewAgent("Agente2", Agente2.class.getName(), null).start();
            agentContainer.createNewAgent("Agente1", Agente1.class.getName(), null).start();
        } catch (StaleProxyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
