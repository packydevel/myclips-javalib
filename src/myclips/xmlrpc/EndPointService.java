package myclips.xmlrpc;

/**
 * Interfaccia richiesta ad un servizio linkato ad un end-point
 * @author Francesco Capozzo
 *
 */
public interface EndPointService {

	String getServiceClass();
	@SuppressWarnings("rawtypes")
	Class getInterface();
	
}
