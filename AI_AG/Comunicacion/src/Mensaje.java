import java.io.Serializable;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;


public class Mensaje{
    public static void enviarMensaje(Agent emisor, String receptor, String mensaje, int tipo, String id){
        AID aid = new AID();
        aid.setLocalName(receptor);
        ACLMessage acl = new ACLMessage(tipo);

        acl.addReceiver(aid);
        acl.setContent(mensaje);
        acl.setSender(emisor.getAID());
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setConversationId(id);

        emisor.send(acl);

    }

    public static void enviarMensajeObj(Agent emisor, String receptor, Serializable obj , int tipo, String id){
        AID aid = new AID();
        aid.setLocalName(receptor);
        ACLMessage acl = new ACLMessage(tipo);

        acl.addReceiver(aid);
        try {
            acl.setContentObject(obj);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        acl.setSender(emisor.getAID());
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setConversationId(id);

        emisor.send(acl);

    }
}