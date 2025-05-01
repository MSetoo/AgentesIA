import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
//tarea 
// 53421 primero se hacen los que 
/*
 * agente uno se comunica con los hijos:uno es normal y y el otro es infinito del agente 5 
 * cada que se envia se mata 
 */
public class Agente2 extends Agent{
    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }
    //ESTOY CREANDO UN NUEVO AGENTE CON EL ULTMO SUSPIRO DEL AG2 Y ESTE ESTA EN EL MISMO CONTENEDOR 
    protected void takeDown() {
        AgentContainer agenteContenedor =(AgentContainer)getArguments()[0];
        int i  =(int)getArguments()[1];
        i= i+1;
        try {
            agenteContenedor.createNewAgent("AgenteH"+i, AgenteH.class.getName(), 
            new Object[]{agenteContenedor,i}).start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
        
    }
    class Comportamiento extends Behaviour{ //comportamiento secuencial 
        private boolean done = false;
        @Override
        public void action() {
            ACLMessage acl = blockingReceive();

            try {
                Cliente c1 = (Cliente)acl.getContentObject(); // hago un casteo
                System.out.println(c1.getIdPersona());
                done = true;
                doDelete();//para eliminar al agente
            } catch (UnreadableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // if(acl.getConversationId().equalsIgnoreCase("AG1-AG2")){
            //     Mensaje.enviarMensaje(getAgent(), acl.getSender().getLocalName(), "Hola, soy" + getName(), ACLMessage.INFORM , "AG2-AG1");
            // }
        }
        @Override
        public boolean done (){
            // para controlar las veces que quiero que haga el comportamiento
            return done;
        }
    }
    
}
