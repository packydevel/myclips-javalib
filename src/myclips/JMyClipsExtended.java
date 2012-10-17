package myclips;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.management.ServiceNotFoundException;

import myclips.xmlrpc.ConnectionFailed;
import myclips.xmlrpc.EndPoint;
import myclips.xmlrpc.listener.ClientListener;
import myclips.xmlrpc.services.ClientEvents;
import myclips.xmlrpc.services.ClientIO;
import myclips.xmlrpc.services.InvalidServiceException;
import myclips.xmlrpc.stream.ClientStream;
import myclips.xmlrpc.stream.ConsoleInputClientStream;
import myclips.xmlrpc.stream.ConsoleOutputClientStream;

public class JMyClipsExtended extends JMyClips {
	
	private String localIp = null;
	protected ClientIO io = null;
	protected ClientEvents events = null;
	
	public JMyClipsExtended(String serverAddress, String localIp) throws ConnectionFailed,
			MalformedURLException {
		super(serverAddress);
		
		this.localIp = localIp;
		
	}
	
	public JMyClipsExtended(URL serverAddress, String localIp) throws ConnectionFailed,
			MalformedURLException {
		this(serverAddress.toString(), localIp);
	}
	
	public ClientIO getClientIOService() throws ServiceNotFoundException, InvalidServiceException {
		if (io == null) {
			getBackend().addService("ClientIO", ClientIO.class);
			io = (ClientIO) getBackend().getService("ClientIO");
		}
		return io;
	}

	public ClientEvents getClientEventsService() throws ServiceNotFoundException, InvalidServiceException {
		if (events == null) {
			getBackend().addService("ClientEvents", ClientIO.class);
			events = (ClientEvents) getBackend().getService("ClientEvents");
		}
		return events;
	}

	public EndPoint registerOutputResource(String resourceName, PrintStream pStream) throws ServiceNotFoundException, InvalidServiceException, Exception{
		return getClientIOService().register(localIp, resourceName, pStream, ConsoleOutputClientStream.class);		
	}
	
	public EndPoint registerInputResource(String resourceName, InputStream iStream) throws ServiceNotFoundException, InvalidServiceException, Exception {
		return getClientIOService().register(localIp, resourceName, iStream, ConsoleInputClientStream.class);		
	}

	public <T extends ClientStream> EndPoint registerOutputResource(String resourceName, PrintStream pStream, Class<T> handler) throws ServiceNotFoundException, InvalidServiceException, Exception{
		return getClientIOService().register(localIp, resourceName, pStream, handler);		
	}
	
	public <T extends ClientStream> EndPoint registerInputResource(String resourceName, InputStream iStream, Class<T> handler) throws ServiceNotFoundException, InvalidServiceException, Exception {
		return getClientIOService().register(localIp, resourceName, iStream, handler);		
	}
	
	
	public <T extends ClientListener> EndPoint registerListeners(String listenerName, Class<T> listener, String[] events) throws ServiceNotFoundException, InvalidServiceException, Exception {
		return getClientEventsService().register(localIp, listenerName, listener, events);
	}
	
	
	public boolean redirectStdInOut() {
		try {
			registerOutputResource("stdout", System.out);
			registerInputResource("stdin", System.in);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
