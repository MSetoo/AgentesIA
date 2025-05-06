import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class Agente3 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());        
    }
    class Comportamiento extends Behaviour {
        private boolean done = false; 
        @Override
        public void action() {
            ACLMessage ac2 = blockingReceive();
            System.out.println("Mensaje recibido: " + ac2.getContent());
            //System.out.println("De: " + ac2.getSender().getLocalName());
            Mensaje.enviarMensaje(this.getAgent(), "Agente5", "Hola Agente 5", ACLMessage.REQUEST, "AG3-AG5");
            //System.out.println(ac2);
            //done = true;
            doDelete();
        }

        @Override
        public boolean done() {
            return done;
        }
    }
    @Override
    protected void takeDown() {
        //System.out.println(  getLocalName() + " : Adios Tonotos :c");
    }
    
}
