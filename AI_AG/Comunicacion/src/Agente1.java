import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente1 extends Agent{
    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            Cliente cliente1= new Cliente(1,1,1,1,1,1);        
           // Mensaje.enviarMensaje(getAgent(), "Agente2", "Hola", ACLMessage.REQUEST , "AG1-AG2");aqui mando un string 
            Mensaje.enviarMensajeObj(getAgent(), "Agente2", cliente1, ACLMessage.REQUEST , "AG1-AG2"); // aqui mando  un objeto
            ACLMessage acl = blockingReceive();
            System.out.println(acl);
        }
    }

}