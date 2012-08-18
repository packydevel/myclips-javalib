package myclips.xmlrpc.services;

import org.apache.xmlrpc.XmlRpcException;

import myclips.xmlrpc.MyClips;

public class AService implements IService {

	protected MyClips owner = null;
	protected String linkedServiceName = null;
	
	AService() {}
	
	public static IService factory(Class<IService> theServiceClass, MyClips owner, String linkedServiceName) throws InstantiationException, IllegalAccessException {
		IService theService = (IService) theServiceClass.newInstance();
		
		return theService
					.setOwner(owner)
					.setLinkedServiceName(linkedServiceName);
		
	}
	
	@Override
	public IService setOwner(MyClips owner) {
		this.owner = owner;
		return this;
	}

	@Override
	public IService setLinkedServiceName(String theName) {
		this.linkedServiceName = theName;
		return this;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T doGeneric(String methodName, boolean sessionized, Class<T> returnType, Object... args) throws XmlRpcException {
		
		return (T) this.doGeneric(methodName, sessionized, args);
		
	}
	
	@Override
	public Object doGeneric(String methodName, boolean sessionized, Object... args) throws XmlRpcException {
		
		String realMethod = this.linkedServiceName + "." + methodName;
		
		return this.owner.getConnection().send(realMethod, sessionized, args);
		
	}
	
	@Override
	public void close() {
		// standard implementation: does nothing
	}

	@Override
	public String getName() {
		try {
			return (String) this.getClass().getField("SERVICE_NAME").get(this.getClass());
		} catch (Exception e) {
			return "AService";
		}
	}
	
	@Override
	public boolean isValid() {
		try {
			this.doGeneric("ping", true);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
