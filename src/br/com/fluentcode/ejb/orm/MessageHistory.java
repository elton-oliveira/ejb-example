package br.com.fluentcode.ejb.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * ORM to test JBosss DataSource configuration
 *
 */
@Entity
public class MessageHistory {
	
	@GeneratedValue
	@Id
	private Integer id;
	
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
