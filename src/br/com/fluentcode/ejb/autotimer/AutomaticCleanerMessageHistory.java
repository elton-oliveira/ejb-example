package br.com.fluentcode.ejb.autotimer;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.com.fluentcode.ejb.dao.MessageHistoryDAOBean;

@Singleton
@Startup
public class AutomaticCleanerMessageHistory {
	
	@EJB
	private MessageHistoryDAOBean messageHistoryDAO;
	
	@PostConstruct
	public void postConstruct(){
		System.out.println("=============== Singleton created on application startup ===============");
	}
	
	//To test, change to run every 3 seconds: @Schedule(second =" */3 ", minute ="*", hour ="*")
	@Schedule(dayOfWeek="Mon,Wed", hour="8", minute="30")
	public void clean(){
		int number = this.messageHistoryDAO.deleteAll();
		System.out.println(number+" deleted entities");
	}
	

}
