package br.com.fluentcode.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fluentcode.ejb.orm.MessageHistory;

@Stateless
public class MessageHistoryDAOBean implements MessageHistoryDAOLocal{
	
	@PersistenceContext(unitName="fluentcode")
	private EntityManager em;
	
	public void persist(MessageHistory messageHistory){
		this.em.persist(messageHistory);
	}

}
