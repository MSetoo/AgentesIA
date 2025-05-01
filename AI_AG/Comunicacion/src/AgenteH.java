import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class AgenteH extends Agent  {
    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());        
    }
    // metodo por recursividad para crear un agente lo cre y lo elimino como yn blucle 
    protected void takeDown (){
        System.out.println("heeeee muerto xdont : "+ getName());
        
         AgentContainer agenteContenedor =(AgentContainer)getArguments()[0];
        int i  =(int)getArguments()[1];
        i= i+1;
        System.out.println(i);
        try {
            agenteContenedor.createNewAgent("AgenteH"+i, AgenteH.class.getName(), 
            new Object[]{agenteContenedor,i}).start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
        
        
    }
    class Comportamiento extends Behaviour{
        @Override
        public void action() {
            System.out.println("Agente vivo : "+ getName());
            doDelete(); //para eliminar al agente
        }
        @Override
        public boolean done() {
            return true;
        }
    }
}
