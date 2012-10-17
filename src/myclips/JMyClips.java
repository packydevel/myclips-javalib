package myclips;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.management.ServiceNotFoundException;

import org.apache.commons.codec.binary.Base64;
import org.apache.xmlrpc.XmlRpcException;

import myclips.xmlrpc.ConnectionFailed;
import myclips.xmlrpc.MyClips;
import myclips.xmlrpc.services.Engine;
import myclips.xmlrpc.services.InvalidServiceException;
import myclips.xmlrpc.services.RemoteShell;

/**
 * FACADE:
 * 	Facilita l'utilizzo di un'istanza remota di myclips 
 * @author Francesco Capozzo
 *
 */
public class JMyClips {

	private MyClips backend = null;
	protected RemoteShell rs = null;
	protected Engine engine = null;

	public JMyClips(String serverAddress) throws ConnectionFailed, MalformedURLException {
		backend = new MyClips(serverAddress);
	}
	
	public JMyClips(URL serverAddress) throws ConnectionFailed, MalformedURLException {
		this(serverAddress.toString());
	}

	
	/**
	 * Legge e trasmette un file LOCALE in formato CLP al server, che provvede a caricarlo
	 * @param theFile
	 * @throws XmlRpcException
	 * @throws IOException
	 * @throws ServiceNotFoundException
	 * @throws InvalidServiceException
	 */
	public void loadLocaleFile(File theFile) throws XmlRpcException, IOException, ServiceNotFoundException, InvalidServiceException {
		
		String theFileContent = JMyClips.readFileAsString(theFile);
		
		byte[] encoded = Base64.encodeBase64(theFileContent.getBytes());
		
		String theEncodedContent = new String(encoded);
		
		getRemoteShellService().doDo("(load \""+ theEncodedContent + "\")");
		
	}
	
	/**
	 * Richiede al server la lettura e il caricamento di un file REMOTO in formato CLP
	 * @param remotePath
	 * @throws ServiceNotFoundException
	 * @throws InvalidServiceException
	 * @throws XmlRpcException
	 */
	public void loadRemoteFile(String remotePath) throws ServiceNotFoundException, InvalidServiceException, XmlRpcException {
		getRemoteShellService().doDo("(server-load \""+ remotePath + "\")");
	}
	
	/**
	 * Esegue un comando generico, sintassi CLP
	 * @param str
	 * @return
	 * @throws ServiceNotFoundException
	 * @throws InvalidServiceException
	 * @throws XmlRpcException
	 */
	public Object execCommand(String str) throws ServiceNotFoundException, InvalidServiceException, XmlRpcException {
		return getRemoteShellService().doDo(str);
	}
	
	protected MyClips getBackend() {
		return backend;
	}
	
	public RemoteShell getRemoteShellService() throws ServiceNotFoundException, InvalidServiceException {
		if ( this.rs == null ) {
			backend.addService("RemoteShell", RemoteShell.class);
			this.rs = (RemoteShell) backend.getService("RemoteShell");
		}
		
		return this.rs;
	}
	
	public Engine getEngineService() throws ServiceNotFoundException, InvalidServiceException {
		if (this.engine == null ) {
			backend.addService("Engine", Engine.class);
			this.engine = (Engine) backend.getService("Engine");
		}
		return this.engine;
	}
	
	private static String readFileAsString(File theFile)
			throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(theFile));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}
	
	
}
