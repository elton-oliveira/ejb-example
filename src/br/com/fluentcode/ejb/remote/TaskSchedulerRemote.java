package br.com.fluentcode.ejb.remote;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface TaskSchedulerRemote {

	void scheduleTask(Date date, Serializable info);
	
	List<String> cancelTask();

}
