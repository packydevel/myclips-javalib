package myclips.xmlrpc.services;

import java.io.InputStream;
import java.io.PrintStream;

import myclips.xmlrpc.EndPoint;
import myclips.xmlrpc.stream.ClientStream;
import myclips.xmlrpc.stream.StreamSecurity;

import org.apache.xmlrpc.XmlRpcException;

/**
 * Mappa il servizio ClientIO_ClientIO
 * 
 * @author Francesco Capozzo
 *
 */
public class ClientIO extends AService {
	
	public static final String SERVICE_NAME = "ClientIO_ClientIO";
	
	/**
	 * Registra uno stream name ad un indirizzo
	 * @param aStreamName il nome stream
	 * @param aStreamAddress l'indirizzo
	 * @param aReverseToken il token
	 * @throws XmlRpcException
	 */
	public void register(String aStreamName, String aStreamAddress, int aReverseToken) throws XmlRpcException {
		this.doGeneric("register", true, aStreamName, aStreamAddress, aReverseToken);
	}
	
	/**
	 * Crea e registra un endpoint per uno stream di output
	 * @param clientExternalIp l'indirizzo esterno di questo client (il server spedira' messaggi a questo indirizzo). Solo IP. La porta e' automatica
	 * @param aStreamName il nome dello stream da mappare
	 * @param ps il print stream locale
	 * @param csClass la classe clientstream
	 * @return
	 * @throws Exception
	 */
	public <T extends ClientStream> EndPoint register(String clientExternalIp, String aStreamName, PrintStream ps, Class<T> csClass) throws Exception {
		
		T cs = csClass.getConstructor(PrintStream.class).newInstance(ps);
		
		EndPoint ep = new EndPoint(cs, clientExternalIp);
		ep.start(true);
		
		this.register( aStreamName, ep.getAddress(), StreamSecurity.getToken(cs) );
		
		return ep;
		
	}
	
	/**
	 * Crea e registra un endpoint per uno stream di output
	 * @param clientExternalIp l'indirizzo esterno di questo client (il server spedira' messaggi a questo indirizzo). Solo IP. La porta e' automatica
	 * @param aStreamName il nome dello stream da mappare
	 * @param ps l'input stream locale
	 * @param csClass la classe clientstream
	 * @return
	 * @throws Exception
	 */
	public <T extends ClientStream> EndPoint register(String clientExternalIp, String aStreamName, InputStream ps, Class<T> csClass) throws Exception {
		
		T cs = csClass.getConstructor(InputStream.class).newInstance(ps);
		
		EndPoint ep = new EndPoint(cs, clientExternalIp);
		ep.start(true);
		
		this.register( aStreamName, ep.getAddress(), StreamSecurity.getToken(cs) );
		
		return ep;
		
	}
	
	/**
	 * Scollega un endpoint
	 * @param aStreamName
	 * @throws XmlRpcException
	 */
	public void unregister(String aStreamName) throws XmlRpcException {
		this.doGeneric("unregister", true, aStreamName);
	}
	
	
}
