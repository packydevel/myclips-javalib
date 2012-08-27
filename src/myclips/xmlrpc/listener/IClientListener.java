package myclips.xmlrpc.listener;

import java.util.HashMap;

public interface IClientListener {

	public boolean ping(int token);
	public void notify(Integer token, String anEventName, Object[] args);
	public void close(int token);
	
}
