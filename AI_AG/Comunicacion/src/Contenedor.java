import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;

public class Contenedor {
    public void contenedor(){
        //tiempo de ejecucion (motor)
        Runtime runtime = Runtime.instance();
        //perfil de configuracion para el contenedor
        ProfileImpl profile = new ProfileImpl(null, 1099, null);
        //creacion del contenedor
        AgentContainer agentContainer = runtime.createMainContainer(profile);
        
        agregarAgentes(agentContainer);
    }

    public void agregarAgentes(AgentContainer agentContainer){
        try {
            agentContainer.createNewAgent("Agente2", Agente2.class.getName(), new Object[]{agentContainer,0}).start();
            agentContainer.createNewAgent("Agente1", Agente1.class.getName(), null).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
