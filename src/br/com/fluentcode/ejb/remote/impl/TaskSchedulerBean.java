package br.com.fluentcode.ejb.remote.impl;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import br.com.fluentcode.ejb.remote.TaskSchedulerRemote;

@Stateless
public class TaskSchedulerBean implements TaskSchedulerRemote{
	
	@Resource
	private TimerService timerService;
	
	
	@Override
	public void scheduleTask(Date date, Serializable info){
		this.timerService.createTimer(date, info);
		System.out.println("--> The task was scheduled <--");
	}

	@Timeout
	public void ejbTimeout(Timer timer) {
		System.out.println("--> "+timer.getInfo()+" <--");
	}
	
	@Override
	public void cancelTask(){
		for(Timer timer : this.timerService.getTimers()){
			timer.cancel();
		}
		System.out.println("--> The task was canceled <--");
	}
	
}
