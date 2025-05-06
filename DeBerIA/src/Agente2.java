import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class Agente2 extends Agent{
    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());        
    }
    class Comportamiento extends Behaviour {
        private boolean done = false; 
        @Override
        public void action() {
            //ACLMessage ac2 = blockingReceive();
            Mensaje.enviarMensaje(this.getAgent(), "Agente5", "Hola Agente 5", ACLMessage.REQUEST, "AG2-AG5"); 
            Mensaje.enviarMensaje(this.getAgent(), "Agente4", "Hola Agente 4", ACLMessage.REQUEST, "AG2-AG4"); 
            Mensaje.enviarMensaje(this.getAgent(), "Agente3", "Hola Agente 3", ACLMessage.REQUEST, "AG2-AG3"); 
            done = true;
            doDelete();
        }

        @Override
        public boolean done() {
            return done;
        }
    }
    @Override
    protected void takeDown() {
        //System.out.println( getLocalName()+ " : Adios Tonotos :c");
    }
}
