package br.com.fluentcode.ejb.dao;

import javax.ejb.Local;

import br.com.fluentcode.ejb.orm.MessageHistory;

@Local
public interface MessageHistoryDAOLocal {
	
	void persist(MessageHistory messageHistory);

}
