package br.com.fluentcode.ejb.remote;

import javax.ejb.Remote;
import javax.jms.JMSException;

@Remote
public interface MessageSenderRemote {
	
	void sendMessage(String msg) throws JMSException;

}
