package myclips.xmlrpc.services;

import org.apache.xmlrpc.XmlRpcException;

import myclips.xmlrpc.MyClips;

public interface IService {

	IService setOwner(MyClips owner);
	IService setLinkedServiceName(String theName);
	String getName();
	Object doGeneric(String methodName, boolean sessionized, Object... args) throws XmlRpcException;
	<T> T doGeneric(String methodName, boolean sessionized, Class<T> returnType, Object... args ) throws XmlRpcException;
	boolean isValid();
	void close();
	
}
