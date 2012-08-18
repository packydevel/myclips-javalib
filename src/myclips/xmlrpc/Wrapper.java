package myclips.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.management.ServiceNotFoundException;

import myclips.xmlrpc.services.InvalidServiceException;
import myclips.xmlrpc.services.RemoteShell;
import myclips.xmlrpc.skeleton.myclips.Integer;
import myclips.xmlrpc.skeleton.myclips.Symbol;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;


public class Wrapper {

	public Wrapper() {
		
	}
	
	
	public static void main(String[] args) throws ConnectionFailed, MalformedURLException, InvalidServiceException, XmlRpcException, ServiceNotFoundException  {
		
		
		
		
		MyClips mc = new MyClips("http://localhost:8081/RPC2");
		
		mc.addService("RemoteShell", RemoteShell.class);
		
		RemoteShell rs = (RemoteShell) mc.getService("RemoteShell");
		
		Object theReturn = rs.doDo("(+ 1 1)");
		
		System.out.println(theReturn);
		
		if (theReturn instanceof myclips.xmlrpc.skeleton.myclips.Integer) {
			
			System.out.println( ((myclips.xmlrpc.skeleton.myclips.Integer) theReturn).getContent());
		}
		
		theReturn = rs.doDo("(assert (A B C))");
		
		System.out.println(theReturn);
		
		
		
		
		
/*		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
	    config.setServerURL(new URL("http://127.0.0.1:8081/RPC2"));
	    
	    config.setEnabledForExtensions(true);
	    config.setEnabledForExceptions(true);
	    
	    
	    XmlRpcClient client = new XmlRpcClient();
	    client.setConfig(config);
	    client.setTypeFactory(new NilProofTypeFactory(client));
	    //Object[] params = new Object[]{new Integer(33), new Integer(9)};
	    String theToken = (String) client.execute("Sessions.new", new Object[]{});
	    
	    System.out.println("The token: " + theToken);
		
	    //Object aResult = (Object) client.execute("RemoteShell.do", new Object[]{theToken, "(+ 1 1)" });
	    
	    client.execute("RemoteShell.do", new Object[]{theToken, "(defrule MAIN::andata ?a <- (A B C) => (retract ?a) (assert (C B A)))" });
	    client.execute("RemoteShell.do", new Object[]{theToken, "(defrule MAIN::ritorno ?a <- (C B A) => (retract ?a) (assert (stato ho-finito)))" });
	    client.execute("RemoteShell.do", new Object[]{theToken, "(assert (A B C))" });
	    
	    client.execute("Engine.run", new Object[]{theToken});
	    
	    Object[] aResult = (Object[]) client.execute("Engine.getWmes", new Object[]{theToken});
	    
	    System.out.println("Results:");
	    for ( Object aWme : aResult ) {
	    	System.out.println("\t" + aWme);
	    }
	    
*/	    
	}
	
}

