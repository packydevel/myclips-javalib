package myclips.xmlrpc.services;

import java.io.InputStream;
import java.io.PrintStream;

import myclips.xmlrpc.EndPoint;
import myclips.xmlrpc.stream.ClientStream;
import myclips.xmlrpc.stream.StreamSecurity;

import org.apache.xmlrpc.XmlRpcException;

public class ClientIO extends AService {
	
	public static final String SERVICE_NAME = "ClientIO_ClientIO";
	
	public void register(String aStreamName, String aStreamAddress, int aReverseToken) throws XmlRpcException {
		this.doGeneric("register", true, aStreamName, aStreamAddress, aReverseToken);
	}
	
	public <T extends ClientStream> EndPoint register(String aStreamName, PrintStream ps, Class<T> csClass) throws Exception {
		
		T cs = csClass.getConstructor(PrintStream.class).newInstance(ps);
		
		EndPoint ep = new EndPoint(cs);
		ep.start(true);
		
		this.register( aStreamName, ep.getAddress(), StreamSecurity.getToken(cs) );
		
		return ep;
		
	}
	
	public <T extends ClientStream> EndPoint register(String aStreamName, InputStream ps, Class<T> csClass) throws Exception {
		
		T cs = csClass.getConstructor(InputStream.class).newInstance(ps);
		
		EndPoint ep = new EndPoint(cs);
		ep.start(true);
		
		this.register( aStreamName, ep.getAddress(), StreamSecurity.getToken(cs) );
		
		return ep;
		
	}
	

	public void unregister(String aStreamName) throws XmlRpcException {
		this.doGeneric("unregister", true, aStreamName);
	}
	
	
}
