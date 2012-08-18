package myclips.xmlrpc.services;

import org.apache.xmlrpc.XmlRpcException;

import myclips.xmlrpc.skeleton.ASkeleton;

public class RemoteShell extends AService {
	
	public static final String SERVICE_NAME = "RemoteShell_MyClipsShell";
	
	public Object doDo(String aCommand) throws XmlRpcException {
		return this.owner.getTypesFactory().convert(this.doGeneric("do", true, aCommand));
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ASkeleton> T doDo(String aCommand, Class<T> rClass) throws XmlRpcException {
		return (T) this.owner.getTypesFactory().convert(this.doGeneric("do", true, rClass, aCommand));
	}
	
}
