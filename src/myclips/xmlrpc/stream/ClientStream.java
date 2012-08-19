package myclips.xmlrpc.stream;

import myclips.xmlrpc.EndPointService;

public abstract class ClientStream implements EndPointService, IClientStream {
	
	protected int token = 0;
	
	@Override
	public String getServiceClass() {
		return "Stream";
	}
	
	@Override
	public Class getInterface() {
		return IClientStream.class;
	}
	
	int getToken() {
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
