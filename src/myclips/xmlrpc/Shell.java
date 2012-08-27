package myclips.xmlrpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import myclips.xmlrpc.listener.ConsoleLoggerListener;
import myclips.xmlrpc.services.ClientEvents;
import myclips.xmlrpc.services.ClientIO;
import myclips.xmlrpc.services.RemoteShell;
import myclips.xmlrpc.stream.ConsoleInputClientStream;
import myclips.xmlrpc.stream.ConsoleOutputClientStream;


public class Shell {
	
	static {
		System.setProperty("org.apache.commons.logging.Log", 
							"org.apache.commons.logging.impl.NoOpLog");
	}
	
	
	public static void main(String[] args) throws Exception  {
		

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
		
		
		mc.addService("ClientIO", ClientIO.class);
		ClientIO io = (ClientIO) mc.getService("ClientIO");
		io.register("stdout", System.out, ConsoleOutputClientStream.class);
		io.register("stdin", System.in, ConsoleInputClientStream.class);

		mc.addService("ClientEvents", ClientEvents.class);
		ClientEvents ce = (ClientEvents) mc.getService("ClientEvents");
		
		mc.addService("RemoteShell", RemoteShell.class);
		RemoteShell rs = (RemoteShell) mc.getService("RemoteShell");


		System.out.println("MyCLIPS Java Remote Shell: taking orders... ");
		System.out.println("	(session ends after 5 minutes without commands)");
		System.out.println();
		
		Object rBuffer = null;
		
		boolean listenerOn = false;
		
		while (true) {
			System.out.print(">>> ");
			theRead = stdin.readLine();
			if (theRead.equals("(exit)") ) {
				System.out.println("...BYE!");
				System.exit(0);
			} else if (theRead.equals("(unwatch all)")) {
				if (listenerOn) {
					listenerOn = false;
					ce.unregister("JListener");
				}
				
			} else if (theRead.equals("(watch all)")) {
				if (!listenerOn) {
					listenerOn = true;
					ce.register("JListener", ConsoleLoggerListener.class, ClientEvents.EVENTS.E_FACT_ASSERTED, ClientEvents.EVENTS.E_NODE_ADDED);
				}
			} else {
				rBuffer = rs.doDo(theRead);
				if (rBuffer != null ) {
					System.out.println(rBuffer);
				}
			}
		}
		
	}
	
}

