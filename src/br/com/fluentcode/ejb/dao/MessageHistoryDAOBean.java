package br.com.fluentcode.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.fluentcode.ejb.orm.MessageHistory;

@Stateless
public class MessageHistoryDAOBean{
	
	@PersistenceContext(unitName="fluentcode")
	private EntityManager em;
	
	public void persist(MessageHistory messageHistory){
		this.em.persist(messageHistory);
	}
	
	public int deleteAll(){
		Query query = this.em.createQuery("DELETE FROM MessageHistory");
		return query.executeUpdate();
	}

}
