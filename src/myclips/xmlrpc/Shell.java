package myclips.xmlrpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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


public class Shell {
	
	public static void main(String[] args) throws ConnectionFailed, InvalidServiceException, XmlRpcException, ServiceNotFoundException, IOException  {

		System.out.println("MyCLIPS Java Remote Shell: taking orders... ");
		System.out.println("	(session ends after 5 minutes without commands)");
		System.out.println();
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String theRead;
		
		System.out.print(">>> MyCLIPS XMLRPC Server address? ");
		theRead = stdin.readLine();
		
		MyClips mc;
		
		try {
			mc = new MyClips(theRead);
		} catch (Exception e) {
			System.out.print("		[Invalid address. Fallback to `http://localhost:8081/RPC2`]");
			mc = new MyClips("http://localhost:8081/RPC2");
		}
		
		
		mc.addService("RemoteShell", RemoteShell.class);
		
		RemoteShell rs = (RemoteShell) mc.getService("RemoteShell");


		System.out.println("MyCLIPS Java Remote Shell: taking orders... ");
		System.out.println("	(session ends after 5 minutes without commands)");
		System.out.println();
		
		while (true) {
			System.out.print(">>> ");
			theRead = stdin.readLine();
			if (theRead.equals("(exit)") ) {
				System.out.println("...BYE!");
				System.exit(0);
			} else if ( theRead.equals("(facts)") ) {
				
			} else {
				System.out.println(rs.doDo(theRead));
			}
		}
		
	}
	
}

