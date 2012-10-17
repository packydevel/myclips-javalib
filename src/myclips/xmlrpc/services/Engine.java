package myclips.xmlrpc.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlrpc.XmlRpcException;

import myclips.xmlrpc.skeleton.ASkeleton;
import myclips.xmlrpc.skeleton.myclips.Fact;
import myclips.xmlrpc.skeleton.myclips.MyClipsConstruct;
import myclips.xmlrpc.skeleton.myclips.WME;

/**
 * Mappa il servizio RemoteShell_MyClipsShell
 * @author Francesco Capozzo
 *
 */
public class Engine extends AService {
	
	public static final String SERVICE_NAME = "Engine_MyClips";
	
	/**
	 * Aggiunge un costrutto rappresentato da uno skeleton
	 * 
	 * @param aConstruct defrule|defmodule|defglobal|deffacts|deffunction|deftemplate
	 * @throws XmlRpcException
	 */
	public void addConstruct(MyClipsConstruct aConstruct) throws XmlRpcException {
		this.doGeneric("addConstruct", true, aConstruct);
	}
	
	/**
	 * Asserisce un nuovo fatto nella working memory
	 * @param aFact un fatto
	 * @return la WME aggiunta
	 * @throws XmlRpcException
	 */
	public WME assertFact(Fact aFact) throws XmlRpcException {
		return (WME) this.owner.getTypesFactory().convert(this.doGeneric("assertFact", true, aFact));
	}
	
	/**
	 * Ritratta una WME
	 * @param wme la wme da ritrattare
	 * @throws XmlRpcException
	 */
	public void retractFact(WME wme) throws XmlRpcException {
		this.doGeneric("retractFactId", true, wme.getFactId());
	}

	/**
	 * Ritratta un fatto con indice i
	 * @param i l'indice del fatto
	 * @throws XmlRpcException
	 */
	public void retractFact(Integer i) throws XmlRpcException {
		this.doGeneric("retractFactId", true, i);
	}
	
	/**
	 * Avvia il ciclo d'esecuzione del motore inferenziale per un numero massimo
	 * di iterazioni
	 * @param steps il numero massimo
	 * @throws XmlRpcException
	 */
	public void run(Integer steps) throws XmlRpcException {
		this.doGeneric("run", true, steps);
	}

	/**
	 * Avvia il ciclo d'esecuzione del motore infereziale, senza limite
	 * @throws XmlRpcException
	 */
	public void run() throws XmlRpcException {
		this.doGeneric("run", true);
	}
	
	/**
	 * Resetta lo stato iniziale
	 * 	(ripristina la wme con i fatti iniziali, i globals con i valori iniziali,
	 * 	conserva le regole, le definizioni di funzioni e template)
	 * @throws XmlRpcException
	 */
	public void reset() throws XmlRpcException {
		this.doGeneric("reset", true);
	}

	/**
	 * Cancella qualsiasi cosa presente nel motore inferenziale,
	 * resettando lo stato iniziale
	 * @throws XmlRpcException
	 */
	public void clear() throws XmlRpcException {
		this.doGeneric("clear", true);
	}
	
	/**
	 * Distrugge il network sul server. Puo' essere necessario
	 * per forzare l'utilizzo di stream remoti 
	 * @throws XmlRpcException
	 */
	public void destroyNetwork() throws XmlRpcException {
		this.doGeneric("destroyNetwork", true);
	}
	
	/**
	 * Ottiene una specifica WME con indice factId
	 * @param factId
	 * @return la wme
	 * @throws XmlRpcException
	 */
	public WME getWme(Integer factId) throws XmlRpcException {
		return (WME) this.owner.getTypesFactory().convert(this.doGeneric("getWme", true, factId));
	}
	
	/**
	 * Ottiene tutte le WMEs per il currentScope di esecuzione del server
	 * @return
	 * @throws XmlRpcException
	 */
	public List<WME> getWmesForCurrentModule() throws XmlRpcException {
		 return toWMEList((Object[]) this.owner.getTypesFactory().convert(this.doGeneric("getWmes", true)));
	}
	
	/**
	 * Ottiene tutte le WMEs realizzate o utilizzabili da un modulo
	 * @param moduleName
	 * @return
	 * @throws XmlRpcException
	 */
	public List<WME> getWmesForModule(String moduleName) throws XmlRpcException {
		 return toWMEList((Object[]) this.owner.getTypesFactory().convert(this.doGeneric("getWmes", true, moduleName)));
	}
	
	/**
	 * Ottiene l'intera working memory
	 * @return
	 * @throws XmlRpcException
	 */
	public List<WME> getAllWmes() throws XmlRpcException {
		 return toWMEList((Object[]) this.owner.getTypesFactory().convert(this.doGeneric("getWmes", true, "*")));
	}
	
	/**
	 * Converte un array di oggetti (che in realta' sono WME) in lista di WME
	 * @param oo
	 * @return
	 */
	private List<WME> toWMEList(Object[] oo) {
		 List<WME> rL = new ArrayList<WME>(oo.length);
		 for ( Object o : oo ) {
			 rL.add((WME) o);
		 }
		 return rL;
	}
	
}
