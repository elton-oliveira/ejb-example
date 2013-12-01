package br.com.fluentcode.ejb.remote.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		System.out.println("--> The task '"+info+"' was scheduled <--");
	}

	@Timeout
	public void ejbTimeout(Timer timer) {
		System.out.println("--> "+timer.getInfo()+" <--");
	}
	
	@Override
	public List<String> cancelTask(){
		List<String> messages = new ArrayList<>();
		for(Timer timer : this.timerService.getTimers()){
			Serializable info = timer.getInfo();
			timer.cancel();
			messages.add("Task '"+info+"' was canceled");
		}
		return messages;
	}
	
}
