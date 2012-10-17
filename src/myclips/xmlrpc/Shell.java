package myclips.xmlrpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.apache.commons.codec.binary.Base64;
import org.apache.xmlrpc.XmlRpcException;

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
		
		
		theRead = "http://localhost:8082/RPC2";
				
		MyClips mc;
		
		try {
			mc = new MyClips(theRead);
		} catch (Exception e) {
			System.out.print("		[Invalid address. Fallback to `http://localhost:8082/RPC2`]");
			mc = new MyClips("http://localhost:8082/RPC2");
		}
		
		
		mc.addService("ClientIO", ClientIO.class);
		ClientIO io = (ClientIO) mc.getService("ClientIO");
		io.register("127.0.0.1", "stdout", System.out, ConsoleOutputClientStream.class);
		io.register("127.0.0.1", "stdin", System.in, ConsoleInputClientStream.class);

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
					ce.register("127.0.0.1", "JListener", ConsoleLoggerListener.class, new String[]{ClientEvents.EVENTS.E_FACT_ASSERTED, ClientEvents.EVENTS.E_NODE_ADDED});
				}
				
			} else if ( theRead.startsWith("(load ")) {
				
				System.out.println("THE FILE: " + theRead.substring("(load Q".length(), theRead.length() - 2 ));
				
				String theFile = theRead.substring("(load Q".length(), theRead.length() - 2 );
				
				String theFileContent = Shell.readFileAsString(theFile);
				
				byte[] encoded = Base64.encodeBase64(theFileContent.getBytes());
				
				String theEncodedContent = new String(encoded);
				
				rBuffer = rs.doDo("(load \""+ theEncodedContent + "\")");
				
				
			} else {
				rBuffer = rs.doDo(theRead);
				if (rBuffer != null ) {
					System.out.println(rBuffer);
				}
			}
		}
		
	}
	
	
	private static String readFileAsString(String filePath)
			throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}
	
}

