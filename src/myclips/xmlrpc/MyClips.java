package myclips.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import myclips.Utils;
import myclips.xmlrpc.services.IService;
import myclips.xmlrpc.skeleton.ASkeleton;
import myclips.xmlrpc.skeleton.InvalidSkeletonException;
import myclips.xmlrpc.skeleton.SkeletonsManager;

public class MyClips {

	protected MyClips.Connection connection = null;
	protected SkeletonsManager typeFactory = null;
	protected Map<String, IService> services = new HashMap<String, IService>();
	
	public MyClips(String serverAddress) throws MalformedURLException, ConnectionFailed {
		this(serverAddress, new SkeletonsManager());
	}
	
	public MyClips(String serverAddress, SkeletonsManager theTypeFactory) throws MalformedURLException, ConnectionFailed {
		this.typeFactory = theTypeFactory;
		this.connection = new MyClips.Connection(new URL(serverAddress));
	}
	
	public <T extends ASkeleton> T create(Class<T> aSkeletonClass ) throws InvalidSkeletonException {
		return this.typeFactory.create(aSkeletonClass);
	}
	
	public <T extends ASkeleton> T create(Class<T> aSkeletonClass, Map<String, Object> args ) throws InvalidSkeletonException {
		return this.typeFactory.create(aSkeletonClass, args);
	}
	
	public MyClips.Connection getConnection() {
		return this.connection;
	}
	
	public MyClips addService(String serviceNameOnServer, Class<IService> serviceClass ) {
		return this;
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

			if (sessionized) {
				args = Utils.prependTo(sessionized, args);
			}
			
			return this.theClient.execute(method, args);
		}
		
	}
	
}
