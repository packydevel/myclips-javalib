package myclips.xmlrpc;

import java.io.IOException;

import myclips.xmlrpc.listener.IClientListener;
import myclips.xmlrpc.services.AService;
import myclips.xmlrpc.stream.ConsoleOutputClientStream;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.RequestProcessorFactoryFactory;
import org.apache.xmlrpc.server.RequestProcessorFactoryFactory.RequestProcessorFactory;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class EndPoint {
	
	protected WebServer theServer = null;
	protected XmlRpcServer theXmlRpcServer = null;
	protected PropertyHandlerMapping phm = null;
	protected EndPointService theService = null;
	
	public EndPoint(EndPointService aService) {
		theService = aService;
	}
	
	protected WebServer getServer() throws XmlRpcException {
		if ( this.theServer == null ) {
			// server initialization code
			
			this.theServer = new WebServer(0);
			this.theXmlRpcServer = this.theServer.getXmlRpcServer();
			this.theXmlRpcServer.setTypeFactory(new NilProofTypeFactory(this.theXmlRpcServer));
			this.phm = new PropertyHandlerMapping();
			
			XmlRpcServerConfigImpl c =
		              (XmlRpcServerConfigImpl) this.theXmlRpcServer.getConfig();
			c.setEnabledForExceptions(true);
			c.setEnabledForExtensions(true);
			c.setContentLengthOptional(false);
			c.setKeepAliveEnabled(true);
			
			this.phm.setVoidMethodEnabled(true);
			
			this.theXmlRpcServer.setHandlerMapping(this.phm);
			
			this.phm.setRequestProcessorFactoryFactory(new ServiceRequestProcessorFactoryFactory(this.theService));
			
			this.phm.addHandler(this.theService.getServiceClass(), this.theService.getInterface());
			
		}
		return this.theServer;
	}
	
	public String getAddress() {
		try {
			return String.format("http://192.168.1.8:%d/xmlrpc", this.getServer().getPort());
		} catch (Exception e) {
			return null;
		}
	}
	
	public void start() throws XmlRpcException {
		this.start(false);
	}
	
	public void start(boolean waitStarup) throws XmlRpcException {
		try {
			this.getServer().start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while ( waitStarup ) {
			try {
				this.getServer().getPort();
				break;
			} catch (Exception e) {
				//System.out.print(".");
			}
		}
	}
	
	public void stop() {
		try {
			this.getServer().shutdown();
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
	}

	public class ServiceRequestProcessorFactoryFactory implements RequestProcessorFactoryFactory {
		
		private final RequestProcessorFactory factory = new ServiceRequestProcessorFactory();
		private final Object aService;

		public ServiceRequestProcessorFactoryFactory(Object aService) {
			this.aService = aService;
		}

		@SuppressWarnings("rawtypes")
		public RequestProcessorFactory getRequestProcessorFactory(Class aClass) throws XmlRpcException {
			return factory;
		}

		private class ServiceRequestProcessorFactory implements RequestProcessorFactory {
			public Object getRequestProcessor(XmlRpcRequest xmlRpcRequest) throws XmlRpcException {
				return aService;
			}
		}
	}
}
