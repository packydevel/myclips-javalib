package myclips.xmlrpc.listener;

import myclips.xmlrpc.EndPointService;

/**
 * Classe astratta per l'implementazione dei listener remoti
 * @author Francesco Capozzo
 *
 */
public abstract class ClientListener implements EndPointService, IClientListener {
	
	protected int token = 0;
	
	@Override
	public String getServiceClass() {
		return "Listener";
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Class getInterface() {
		return IClientListener.class;
	}
	
	public int getToken() {
		return this.token;
	}
	
	protected boolean assertValid(int token) {
		if ( this.token == token ) {
			return true;
		} else {
			throw new RuntimeException();
		}
	}
	
}
