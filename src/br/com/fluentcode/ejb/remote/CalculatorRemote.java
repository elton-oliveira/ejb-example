package br.com.fluentcode.ejb.remote;

import javax.ejb.Remote;

@Remote
public interface CalculatorRemote {
	
	int add(int x, int y);

}
