import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import jade.lang.acl.ACLMessage;
import jade.core.AID;

public class Agente5Hijo extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());        
    }
    
    class Comportamiento extends Behaviour {
        
        @Override
        public void action() {
            System.out.println("Soy el hijo del agente 5");
            Mensaje.enviarMensaje(this.getAgent(), "Agente1", "Hola Agente 1", ACLMessage.REQUEST, "AG5H-AG1");
            ACLMessage ac1 = blockingReceive();
            if (ac1 != null) {
                System.out.println("Respuesta recibida del Agente1: " + ac1.getContent());
            }
        
            doDelete();
        }

        @Override
        public boolean done() {
            return true;
        }
    }
    
    @Override
    protected void takeDown() {

        System.out.println(getLocalName() + " : Adiós... creando otro hijo ");
            AgentContainer agenteContenedor =(AgentContainer)getArguments()[0];
            int i  =(int)getArguments()[1];
            i= i+1;
            System.out.println(i);
            try {
                agenteContenedor.createNewAgent("Agente5Hijo"+i, Agente5Hijo.class.getName(), 
                new Object[]{agenteContenedor,i}).start();
            } catch (StaleProxyException e) {
                e.printStackTrace();
            }
        }
      }
    