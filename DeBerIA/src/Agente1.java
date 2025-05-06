import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
    public class Agente1 extends Agent {
        @Override
        protected void setup() {
            addBehaviour(new Comportamiento());        
        }
        class Comportamiento extends Behaviour {
            private boolean done = false; 
            @Override
            public void action() {
                Mensaje.enviarMensaje (this.getAgent(), "Agente2", "Hola Agente 2", ACLMessage.REQUEST, "AG1-AG2");
                ACLMessage ac5h = blockingReceive(5000);
                System.out.println("Mensaje recibido: " + ac5h.getContent());
                System.out.println("De: " + ac5h.getSender().getLocalName()); 
                ACLMessage respuesta = ac5h.createReply();
                respuesta.setContent("Hola, soy el Agente1. Mensaje recibido.");
                respuesta.setPerformative(ACLMessage.INFORM);
                send(respuesta);               
                //done = true;
                //doDelete();
                
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
