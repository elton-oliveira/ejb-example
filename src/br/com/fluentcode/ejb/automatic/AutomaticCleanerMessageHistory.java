package br.com.fluentcode.ejb.automatic;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.com.fluentcode.ejb.dao.MessageHistoryDAOBean;


// To test, change clean method to run every 3 seconds: @Schedule(second =" */3 ", minute ="*", hour ="*")

@Singleton
@Startup
public class AutomaticCleanerMessageHistory {
	
	@EJB
	private MessageHistoryDAOBean messageHistoryDAO;
	
	@PostConstruct
	private void postConstruct(){
		System.out.println("=============== Singleton created on application startup ===============");
	}
	
	/**
	 * Timers are persistent by default. If the server is shut down or crashes,
	 * persistent timers are saved and will become active again when the server
	 * is restarted. If a persistent timer expires while the server is down, the
	 * container will call the @Timeout method when the server is restarted.
	 */
	@Schedule(dayOfWeek="Mon,Wed", hour="8", minute="30", persistent=false)
	private void clean(){
		int number = this.messageHistoryDAO.deleteAll();
		System.out.println(number+" deleted entities");
	}
	

}
