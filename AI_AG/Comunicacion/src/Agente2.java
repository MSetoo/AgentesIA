import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class Agente2 extends Agent{
    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour{ //comportamiento secuencial 
        private boolean done = false;
        @Override
        public void action() {
            ACLMessage acl = blockingReceive();

            try {
                Cliente c1 = (Cliente)acl.getContentObject(); // hago un casteo
                System.out.println(c1.getTotalFacturas());
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
