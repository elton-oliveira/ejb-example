package br.com.fluentcode.ejb.remote.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import br.com.fluentcode.ejb.remote.MessageSenderRemote;

@Stateless
public class MessageSenderBean implements MessageSenderRemote {
	
	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName = "java:jboss/exported/FluentCodeQueue")
	private Destination destination;

	@Override
	public void sendMessage(String message) throws JMSException {
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer messageProducer = session.createProducer(destination);
		TextMessage textMessage = session.createTextMessage();
		textMessage.setText(message);
		messageProducer.send(textMessage);
		connection.close();
	}

}
