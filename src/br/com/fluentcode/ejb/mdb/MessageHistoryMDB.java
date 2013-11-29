package br.com.fluentcode.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fluentcode.ejb.orm.MessageHistory;

@MessageDriven(activationConfig={
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "FluentCodeQueue")})
public class MessageHistoryMDB implements MessageListener{
	
	@PersistenceContext(unitName="fluentcode")
	private EntityManager em;

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			MessageHistory history = new MessageHistory();
			history.setDescription(textMessage.getText());
			em.persist(history);
			System.out.println("--> "+textMessage.getText()+" <--");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
