package myclips.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.management.ServiceNotFoundException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import myclips.Utils;
import myclips.xmlrpc.services.AService;
import myclips.xmlrpc.services.IService;
import myclips.xmlrpc.services.InvalidServiceException;
import myclips.xmlrpc.skeleton.ASkeleton;
import myclips.xmlrpc.skeleton.InvalidSkeletonException;
import myclips.xmlrpc.skeleton.SkeletonsManager;

/**
 * Manager della connessione e dei servizi offerti
 * dal server myclips
 * @author Francesco Capozzo
 *
 */
public class MyClips {

	/**
	 * Connessione utilizzata
	 */
	protected MyClips.Connection connection = null;
	/**
	 * Il manager degli skeleton
	 */
	protected SkeletonsManager typesFactory = null;
	/**
	 * I servizi mappati in interfacce
	 */
	protected Map<String, IService> services = new HashMap<String, IService>();
	/**
	 * Servizi disponibili sul server
	 */
	private Object[] serviceAvailablesCache = null;
	
	
	/**
	 * Crea un nuovo proxy per il myclips-server usando come
	 * collezione di skeletons quelli in 
	 * "myclips.xmlrpc.skeleton.myclips"
	 * 
	 * @param serverAddress indirizzo del server (ex. http://IP_ADDRESS:PORT/RPC2)
	 * @throws MalformedURLException serverAddress non valido
	 * @throws ConnectionFailed errore durante la connessione
	 */
	public MyClips(String serverAddress) throws MalformedURLException, ConnectionFailed {
		this(serverAddress, new SkeletonsManager("myclips.xmlrpc.skeleton.myclips"));
	}
	
	/**
	 * Crea un nuovo proxy per il myclips-server. 
	 * Il manager degli skeleton determina la conversione degli
	 * 
	 * @param serverAddress indirizzo del server
	 * @param theTypesFactory il manager che gestisce gli skeleton attesi
	 * @throws MalformedURLException serverAddress non valido
	 * @throws ConnectionFailed errore durante la connessione
	 */
	public MyClips(String serverAddress, SkeletonsManager theTypesFactory) throws MalformedURLException, ConnectionFailed {
		this.typesFactory = theTypesFactory;
		this.connection = new MyClips.Connection(new URL(serverAddress));
	}
	
	/**
	 * Facade, utilizza lo SkeletonManager registrato
	 * per creare una nuova istanza
	 * @param aSkeletonClass la classe skeleton da istanziare
	 * @return l'istanza
	 * @throws InvalidSkeletonException
	 */
	public <T extends ASkeleton> T create(Class<T> aSkeletonClass ) throws InvalidSkeletonException {
		return this.typesFactory.create(aSkeletonClass);
	}
	
	/**
	 * Facade, utilizza lo SkeletonManager registrato
	 * per creare una nuova istanza settando i parametri iniziali
	 * @param aSkeletonClass la classe skeleton da istanziare
	 * @param args il dizionario di valori
	 * @return l'istanza
	 * @throws InvalidSkeletonException
	 */
	public <T extends ASkeleton> T create(Class<T> aSkeletonClass, Map<String, Object> args ) throws InvalidSkeletonException {
		return this.typesFactory.create(aSkeletonClass, args);
	}
	
	/**
	 * Getter per connessione
	 * @return la connessione con il server
	 */
	public MyClips.Connection getConnection() {
		return this.connection;
	}
	
	/**
	 * Getter per il manager degli skeleton
	 * @return il manager registrato
	 */
	public SkeletonsManager getTypesFactory() {
		return this.typesFactory;
	}
	
	/**
	 * Mappa un'interfaccia di servizio ad una chiave
	 * di servizio offerta dal myclips-server
	 * @param sKey la chiave di servizio del server
	 * @param serviceClass l'interfaccia di servizio da associare
	 * @return lo stessa istanza MyClips, per fluent
	 * @throws InvalidServiceException l'interfaccia suggerita non e' valida per il servizio
	 * @throws ServiceNotFoundException la chiave di servizio del server non è riconosciuta
	 */
	public MyClips addService(String sKey, Class<? extends IService> serviceClass ) throws InvalidServiceException, ServiceNotFoundException {
		if (this.services.containsKey(sKey)) {
			this.removeService(sKey);
		}
		// check if server expose this service
		if (this.isServiceAvailableOnServer(sKey) ) {
			try {
				this.services.put(sKey, AService.factory(serviceClass, this, sKey));
			} catch (Exception e) {
				throw new InvalidServiceException();
			}
		} else {
			throw new ServiceNotFoundException();
		}
		return this;
	}
	
	/**
	 * Restituisce un'interfaccia di servizio mappata
	 * @param sKey la chiave del servizio
	 * @return il servizio
	 */
	public IService getService(String sKey) {
		return this.services.get(sKey);
	}
	
	/**
	 * Controlla che un servizio sia attivo sul server
	 * @param sKey chiave di servizio
	 * @return True se c'e', False altrimenti
	 */
	public boolean isServiceAvailableOnServer(String sKey) {
		
		Object[] servicesA;
		
		// usa una cache per evitare di ripetere la richiesta
		// della lista dei servizi. Se la cache non e' gia stata
		// popolata, la popola
		if ( this.serviceAvailablesCache == null ) { 
			try {
				servicesA = (Object[]) this.getConnection().send("services", false);
				this.serviceAvailablesCache = servicesA;
			} catch (XmlRpcException e) {
				servicesA = new Object[]{};
			}
		} else {
			servicesA = this.serviceAvailablesCache;
		}
		
		// itera sulla lista di servizi
		for (Object aS : servicesA) {
			/*
			Object[] serviceDescriptor = (Object[]) aS;
			String serviceKey = (String) serviceDescriptor[0];
			String serviceType = (String) serviceDescriptor[1];
			String serviceName = (String) serviceDescriptor[2];
			*/
			try {
				// verifica che il servizio richiesto sia fra quelli disponibili
				// verificando che la chiave del servizio sia uguale a quella
				// richiesta
				if ( ((String) ((Object[]) aS)[0]).equals(sKey) ) {
					//System.out.println( ((String) ((Object[]) aS)[0]) + " vs " + sKey + ": FOUND!" );
					return true;
				} //else System.out.println( ((String) ((Object[]) aS)[0]) + " vs " + sKey  );
			} catch (Exception e) {
				//System.out.println(e);
			}
		}
		
		return false;
				
	}
	
	/**
	 * Rimuove un'interfaccia di servizio mappata
	 * @param serviceName la chiave di servizio
	 * @return la stessa istanza, fluent
	 */
	public MyClips removeService(String serviceName) {
		try {
			this.services.remove(serviceName).close();
		} catch (Exception e) {
			// error on remove = no service with this name
			// error on close = the server report an error
		}
		return this;
	}
	
	
	/**
	 * Rappresenta una connessione con il server
	 * @author Francesco Capozzo
	 *
	 */
	public class Connection {

		/**
		 * client xml-rpc da libreria xmlrpc-client
		 */
		protected XmlRpcClient theClient = null;
		/**
		 * Memorizza il token di sessione, automaticamente
		 * utilizzato per le richieste che richiedono l'accesso
		 * allo stato persistente sul server
		 */
		protected String theToken = null;
		
		/**
		 * Crea una nuova connessione con il server
		 * @param serverAddress
		 * @throws ConnectionFailed
		 */
		public Connection(URL serverAddress) throws ConnectionFailed {
			this(serverAddress, false);
		}
		
		/**
		 * Crea una nuova connessione, impostando un protettore di sessione
		 * automatico che rinnovi la sessione (eseguendo una richiesta a Sessions.renew())
		 * prima della scadenza del termine, se richiesto
		 * TODO non ancora realmente implementato, ma sarebbe utile
		 * @param serverAddress L'indirizzo del server
		 * @param protectSession usare la protezione per la scadenza?
		 * @throws ConnectionFailed connessione fallita
		 */
		public Connection(URL serverAddress, boolean protectSession ) throws ConnectionFailed {
			
			// inizializza la configurazione del client
			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			// impostando l'url del server
		    config.setServerURL(serverAddress);
		    
		    // attiva le estensione xml-rpc 
		    // (serve per fare in modo che il client accetti come tipo di parametro
		    // il valore NULL [che viene mappato nel messaggio come ext:nil].
		    // E' un'estensione del protocollo. Lo standard non accetta nil)
		    config.setEnabledForExtensions(true);
		    
		    // attiva la conversione automatica dei messaggi "fault"
		    // in eccezioni java (classe Fault se nn ricordo male)
		    config.setEnabledForExceptions(true);
		    
		    
		    // inizializza il client
		    this.theClient = new XmlRpcClient();
		    // impostando la configurazione
		    this.theClient.setConfig(config);
		    // sostituisce il type factory:
		    // 		long story short:
		    //		la libreria xmlrpc standard di python attiva il tipo
		    //		null mappandolo su messaggi di tipo nil, non ext:nil
		    //		L'estensione ufficiale si aspetta invece ext:nil
		    //		quindi senza la sostituzione, il valore null non va
		    //		la sostituzione del type factory fa in modo di accettare
		    //		anche messaggi con tipo nil semplice per il NULL
		    this.theClient.setTypeFactory(new NilProofTypeFactory(theClient));
		    
		    //Object[] params = new Object[]{new Integer(33), new Integer(9)};
		    
		    try {
		    	// inizializza la sessione e la memorizza
				this.theToken = (String) this.theClient.execute("Sessions.new", new Object[]{});
			} catch (XmlRpcException e) {
				// se la connessione non va
				// lancia un'eccezione
				throw new ConnectionFailed(String.format("Session creation on %s failed", serverAddress ), e);
			}
		}
		
		/**
		 * Metodo per eseguire chiamate remote in maniera arbitraria
		 * 
		 * @param method il nome del metodo rpc
		 * @param sessionized usare la sessione?
		 * @param args l'array di parametri da passare
		 * @return il risultato
		 * @throws XmlRpcException in caso di errori
		 */
		public Object send(String method, boolean sessionized, Object... args) throws XmlRpcException {

			// DECOMMENTARE PER VEDERE NEL STDOUT I MESSAGGI SCAMBIATI
			/*
			System.out.println("Calling: " + ((XmlRpcClientConfigImpl) this.theClient.getClientConfig()).getServerURL());
			System.out.println("\tMethod: " + method);
			if (sessionized) 
				System.out.println("\tSession: " + sessionized);
			System.out.println("\tArgs: [");
			for (Object o : args) {
				System.out.println("\t\t" + o);
			}
			System.out.println("\t]");
			*/
			
			if (sessionized) {
				args = Utils.prependTo(this.theToken, args);
			}
			
			return this.theClient.execute(method, args);
		}
		
	}
	
}
