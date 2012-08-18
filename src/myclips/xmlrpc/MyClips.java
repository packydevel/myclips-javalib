package myclips.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.management.ServiceNotFoundException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import myclips.Utils;
import myclips.xmlrpc.services.AService;
import myclips.xmlrpc.services.IService;
import myclips.xmlrpc.services.InvalidServiceException;
import myclips.xmlrpc.skeleton.ASkeleton;
import myclips.xmlrpc.skeleton.InvalidSkeletonException;
import myclips.xmlrpc.skeleton.SkeletonsManager;

public class MyClips {

	protected MyClips.Connection connection = null;
	protected SkeletonsManager typesFactory = null;
	protected Map<String, IService> services = new HashMap<String, IService>();
	private Object[] serviceAvailablesCache = null;
	
	public MyClips(String serverAddress) throws MalformedURLException, ConnectionFailed {
		this(serverAddress, new SkeletonsManager("myclips.xmlrpc.skeleton.myclips"));
	}
	
	public MyClips(String serverAddress, SkeletonsManager theTypesFactory) throws MalformedURLException, ConnectionFailed {
		this.typesFactory = theTypesFactory;
		this.connection = new MyClips.Connection(new URL(serverAddress));
	}
	
	public <T extends ASkeleton> T create(Class<T> aSkeletonClass ) throws InvalidSkeletonException {
		return this.typesFactory.create(aSkeletonClass);
	}
	
	public <T extends ASkeleton> T create(Class<T> aSkeletonClass, Map<String, Object> args ) throws InvalidSkeletonException {
		return this.typesFactory.create(aSkeletonClass, args);
	}
	
	public MyClips.Connection getConnection() {
		return this.connection;
	}
	
	public SkeletonsManager getTypesFactory() {
		return this.typesFactory;
	}
	
	public MyClips addService(String sKey, Class<? extends IService> serviceClass ) throws InvalidServiceException, ServiceNotFoundException {
		if (this.services.containsKey(sKey)) {
			this.removeService(sKey);
		}
		// check if server expose this service
		if (this.isServiceAvailableOnServer(sKey) ) {
			try {
				this.services.put(sKey, AService.factory(serviceClass, this, sKey));
			} catch (Exception e) {
				throw new InvalidServiceException();
			}
		} else {
			throw new ServiceNotFoundException();
		}
		return this;
	}
	
	public IService getService(String sKey) {
		return this.services.get(sKey);
	}
	
	public boolean isServiceAvailableOnServer(String sKey) {
		
		Object[] servicesA;
		
		if ( this.serviceAvailablesCache == null ) { 
			try {
				servicesA = (Object[]) this.getConnection().send("services", false);
				this.serviceAvailablesCache = servicesA;
			} catch (XmlRpcException e) {
				servicesA = new Object[]{};
			}
		} else {
			servicesA = this.serviceAvailablesCache;
		}
		
		for (Object aS : servicesA) {
			/*
			Object[] serviceDescriptor = (Object[]) aS;
			String serviceKey = (String) serviceDescriptor[0];
			String serviceType = (String) serviceDescriptor[1];
			String serviceName = (String) serviceDescriptor[2];
			*/
			try {
				if ( ((String) ((Object[]) aS)[0]).equals(sKey) ) {
					//System.out.println( ((String) ((Object[]) aS)[0]) + " vs " + sKey + ": FOUND!" );
					return true;
				} //else System.out.println( ((String) ((Object[]) aS)[0]) + " vs " + sKey  );
			} catch (Exception e) {
				//System.out.println(e);
			}
		}
		
		return false;
				
	}
	
	public MyClips removeService(String serviceName) {
		try {
			this.services.remove(serviceName).close();
		} catch (Exception e) {
			// error on remove = no service with this name
			// error on close = the server report an error
		}
		return this;
	}
	
	
	public class Connection {

		protected XmlRpcClient theClient = null;
		protected String theToken = null;
		
		public Connection(URL serverAddress) throws ConnectionFailed {
			this(serverAddress, true);
		}
		
		public Connection(URL serverAddress, boolean protectSession ) throws ConnectionFailed {
			
			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		    config.setServerURL(serverAddress);
		    
		    config.setEnabledForExtensions(true);
		    config.setEnabledForExceptions(true);
		    
		    
		    this.theClient = new XmlRpcClient();
		    this.theClient.setConfig(config);
		    this.theClient.setTypeFactory(new NilProofTypeFactory(theClient));
		    
		    //Object[] params = new Object[]{new Integer(33), new Integer(9)};
		    
		    try {
				this.theToken = (String) this.theClient.execute("Sessions.new", new Object[]{});
			} catch (XmlRpcException e) {
				// TODO Auto-generated catch block
				throw new ConnectionFailed(String.format("Session creation on %s failed", serverAddress ), e);
			}
		}
		
		public Object send(String method, boolean sessionized, Object... args) throws XmlRpcException {

			System.out.println("Calling: " + ((XmlRpcClientConfigImpl) this.theClient.getClientConfig()).getServerURL());
			System.out.println("\tMethod: " + method);
			if (sessionized) 
				System.out.println("\tSession: " + sessionized);
			System.out.println("\tArgs: [");
			for (Object o : args) {
				System.out.println("\t\t" + o);
			}
			System.out.println("\t]");
			
			if (sessionized) {
				args = Utils.prependTo(this.theToken, args);
			} else {
				
			}
			
			return this.theClient.execute(method, args);
		}
		
	}
	
}
