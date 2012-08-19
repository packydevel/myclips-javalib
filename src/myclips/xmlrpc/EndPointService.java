package myclips.xmlrpc;

public interface EndPointService {

	String getServiceClass();
	@SuppressWarnings("rawtypes")
	Class getInterface();
	
}
