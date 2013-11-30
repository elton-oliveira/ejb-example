package br.com.fluentcode.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.com.fluentcode.ejb.dao.MessageHistoryDAOLocal;
import br.com.fluentcode.ejb.orm.MessageHistory;

@MessageDriven(activationConfig={
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "FluentCodeQueue")})
public class MessageHistoryMDB implements MessageListener{
	
	@EJB
	private MessageHistoryDAOLocal dao;

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			MessageHistory history = new MessageHistory();
			history.setDescription(textMessage.getText());
			dao.persist(history);
			System.out.println("--> "+textMessage.getText()+" <--");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
