package myclips.xmlrpc.services;

import org.apache.xmlrpc.XmlRpcException;

import myclips.xmlrpc.MyClips;

/**
 * Interfaccia richiesta ai proxy di servizi remoti
 * @author Francesco Capozzo
 *
 */
public interface IService {
	
	/**
	 * Imposta il manager dei servizi proprietario del servizio
	 * @param owner
	 * @return fluent
	 */
	IService setOwner(MyClips owner);
	/**
	 * Imposta la chiaver del servizio remoto collegato a questo
	 * @param theName
	 * @return fluent
	 */
	IService setLinkedServiceName(String theName);
	/**
	 * Indica il nome del servizio
	 * @return
	 */
	String getName();
	/**
	 * Esecuzione generica di un comando rpc, con contesto del servizio
	 * @param methodName il nome del metodo
	 * @param sessionized e' richiesta la sessione?
	 * @param args i parametri
	 * @return
	 * @throws XmlRpcException
	 */
	Object doGeneric(String methodName, boolean sessionized, Object... args) throws XmlRpcException;
	/**
	 * Esegue una chiamata generica, convertendo il valore di ritorno
	 * @param methodName il nome del metodo
	 * @param sessionized e' richiesta la sessione?
	 * @param returnType il tipo del valore di ritorno
	 * @param args i valori
	 * @return
	 * @throws XmlRpcException
	 */
	<T> T doGeneric(String methodName, boolean sessionized, Class<T> returnType, Object... args ) throws XmlRpcException;
	/**
	 * Controlla se il servizio e' valido
	 * @return
	 */
	boolean isValid();
	/**
	 * Notifica l'eventuale chiusura del servizio
	 */
	void close();
	
}
