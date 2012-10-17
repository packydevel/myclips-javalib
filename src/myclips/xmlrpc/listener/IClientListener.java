package myclips.xmlrpc.listener;

import java.util.HashMap;

/**
 * Interfaccia RICHIESTA dal server ad un 
 * listener remoto
 * @author Francesco Capozzo
 *
 */
public interface IClientListener {

	/**
	 * Controlla che l'endpoint sia valido per il reverse-token indicato
	 * @param token
	 * @return vero se il token e' corretto
	 */
	public boolean ping(int token);
	/**
	 * Notifica un evento
	 * @param token
	 * @param anEventName
	 * @param args
	 */
	public void notify(Integer token, String anEventName, Object[] args);
	/**
	 * Notifica la disconnessione di un listener
	 * @param token
	 */
	public void close(int token);
	
}
