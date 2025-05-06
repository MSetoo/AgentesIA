import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class Agente5 extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());        
    }
    class Comportamiento extends Behaviour {
        private boolean done = false; 
        @Override
        public void action() {
            ACLMessage ac4 = blockingReceive();
            ACLMessage ac3 = blockingReceive();
            ACLMessage ac2 = blockingReceive();
            System.out.println("Mensaje recibido: " + ac2.getContent());
            System.out.println("De: " + ac2.getSender().getLocalName());
            System.out.println("Mensaje recibido: " + ac4.getContent());
            System.out.println("De: " + ac4.getSender().getLocalName());
            System.out.println("Mensaje recibido: " + ac3.getContent());
            System.out.println("De: " + ac3.getSender().getLocalName());
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
        //asi se crea un solo hijo
        // System.out.println(getLocalName() + " : Adios Tonotos :c, PERO LES DEJO UN HIJO.....");
        // AgentContainer agenteContenedor = (AgentContainer) getArguments()[0];
        // try {
        //     agenteContenedor.createNewAgent("Agente5Hijo", Agente5Hijo.class.getName(), new Object[]{agenteContenedor,0}).start();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        AgentContainer agenteContenedor =(AgentContainer)getArguments()[0];
        int i  =(int)getArguments()[1];
        i= i+1;
        try {
            agenteContenedor.createNewAgent("AgenteH"+i, Agente5Hijo.class.getName(), 
            new Object[]{agenteContenedor,i}).start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}