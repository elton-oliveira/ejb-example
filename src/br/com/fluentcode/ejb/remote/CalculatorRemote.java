package br.com.fluentcode.ejb.remote;

import javax.ejb.Remote;

/**
 * 
 * TODO Preciso tirar o jboss-client.jar daqui preciso, pois isso não é um client.
 * Na hora de executar vai usar o recursos do container. Mas para compilar preciso ver como
 * resolver com o ant e ivy (adicionar um lib com scope de ...)
 *
 */
@Remote
public interface CalculatorRemote {
	
	int add(int x, int y);

}
