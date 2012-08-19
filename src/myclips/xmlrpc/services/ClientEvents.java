package myclips.xmlrpc.services;

import java.io.InputStream;
import java.io.PrintStream;

import myclips.xmlrpc.EndPoint;
import myclips.xmlrpc.listener.ClientListener;
import myclips.xmlrpc.stream.ClientStream;
import myclips.xmlrpc.stream.StreamSecurity;

import org.apache.xmlrpc.XmlRpcException;

public class ClientEvents extends AService {
	
	public static final String SERVICE_NAME = "ClientEvents_ClientEvents";
	
	public void register(String aListenerName, String aListenerAddress, int aReverseToken, String... events) throws XmlRpcException {
		this.doGeneric("register", true, aListenerName, aListenerAddress, aReverseToken, events);
	}
	
	public <T extends ClientListener> EndPoint register(String aListenerName, Class<T> clClass, String...events) throws Exception {
		
		T cl = clClass.newInstance();
		
		EndPoint ep = new EndPoint(cl);
		ep.start(true);
		
		this.register( aListenerName, ep.getAddress(), cl.getToken(), events );
		
		return ep;
		
	}
	

	public void unregister(String aListenerName) throws XmlRpcException {
		this.doGeneric("unregister", true, aListenerName);
	}
	
	public class EVENTS {
		
	    public static final String E_RULE_FIRED  = "rule-fired";
	    public static final String E_RULE_ACTIVATED  = "rule-activated";
	    public static final String E_RULE_DEACTIVATED  = "rule-deactivated";
	    public static final String E_RULE_ADDED  = "rule-added";
	    public static final String E_RULE_REMOVED  = "rule-removed";
	    
	    public static final String E_NODE_ADDED  = "node-added";
	    public static final String E_NODE_REMOVED  = "node-removed"; 
	    public static final String E_NODE_LINKED  = "node-linked";
	    public static final String E_NODE_UNLINKED  = "node-unlinked";
	    public static final String E_NODE_ACTIVATED  = "node-activated";
	    public static final String E_NODE_ACTIVATED_LEFT  = "node-activated-left";
	    public static final String E_NODE_ACTIVATED_RIGHT  = "node-activated-right";
	    public static final String E_NODE_SHARED  = "node-shared";

	    public static final String E_FACT_ASSERTED  = "fact-asserted";
	    public static final String E_FACT_RETRACTED  = "fact-retracted";
	    
	    public static final String E_ACTION_PERFORMED  = "action-performed";
	    
	    public static final String E_STRATEGY_CHANGED  = "strategy-changed";

	    public static final String E_DEBUG_OPTIONS_CHANGED  = "debug-options-changed";
	    
	    public static final String E_NETWORK_RESET_PRE  = "network-reset-pre";
	    public static final String E_NETWORK_RESET_POST  = "network-reset-post";
	    public static final String E_NETWORK_CLEAR_PRE  = "network-reset-pre";
	    public static final String E_NETWORK_CLEAR_POST  = "network-reset-post";
	    public static final String E_NETWORK_READY  = "network-ready";
	    public static final String E_NETWORK_SHUTDOWN  = "network-shutdown";
	    
		private EVENTS() {}
	}
	
}
