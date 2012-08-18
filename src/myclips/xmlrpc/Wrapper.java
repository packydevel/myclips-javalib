package myclips.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;

import myclips.xmlrpc.skeleton.myclips.Symbol;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;


public class Wrapper {

	public Wrapper() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void main(String[] args) throws MalformedURLException, XmlRpcException {

		System.out.println(new Symbol());
		System.out.println(new myclips.xmlrpc.skeleton.myclips.String());
		
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

