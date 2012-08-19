package myclips.xmlrpc;

public interface IClientEndPoint {

	void registerWithName(String eName);
	void unregister(String eName);
	void unregister();
	
}
