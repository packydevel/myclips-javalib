package myclips.xmlrpc.skeleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.reflections.Reflections;

public class SkeletonsManager {
	
	protected String sPackage = null;
	protected Map<String, Class<? extends ASkeleton>> skeletons = new HashMap<String, Class<? extends ASkeleton>>();
			
	public SkeletonsManager(String sPackage) {
		
		this.sPackage = sPackage;
		
		Reflections reflections = new Reflections(this.sPackage);
		
		for ( Class<? extends ASkeleton> aSkeleton : reflections.getSubTypesOf(ASkeleton.class) ) {
			
			this.skeletons.put(ASkeleton.getSkeletonType(aSkeleton), aSkeleton);
			
		}
		
	}
	
	public <T extends ASkeleton> T create(Class<T> aSkeletonClass ) throws InvalidSkeletonException {
		try {
			return aSkeletonClass.newInstance();
		} catch (Exception e) {
			throw new InvalidSkeletonException("Invalid skeleton: "+aSkeletonClass);
		}
	}
	
	public <T extends ASkeleton> T create(Class<T> aSkeletonClass, Map<String, Object> args ) throws InvalidSkeletonException {
		T theSkeleton = this.create(aSkeletonClass);
		
		for (Map.Entry<String, Object> entry : args.entrySet()) {
		    theSkeleton.setField(entry.getKey(), entry.getValue());
		}
		
		return theSkeleton;
	}
	
	public Object convert(Object[] pObject) {
		
		List<Object> l = new ArrayList<Object>(pObject.length);
		
		for (int i = 0; i < pObject.length; i++ ) {
			l.add(i, this.convert(pObject[i]));
		}
		
		return l;
		
	}
	
	public Object convert(Map<?,?> pObject) {
		
		Object theReturn = null;
		
		try {
			
			theReturn = this.parseSkeleton(((Map<Object, Object>) pObject));
		
		} catch (InvalidSkeletonException e) {
			
			Map<String, Object> m = new HashMap<String, Object>(pObject.size());
			
			for ( Map.Entry<Object, Object> entry : ((Map<Object, Object>) pObject).entrySet() ) {
				m.put(entry.getKey().toString(), this.convert(entry.getValue()));
			}
			
			theReturn = m;
		}
		
		return theReturn;
		
	}
	
	public Object convert(Object pObject) {
		if (pObject instanceof Map) {
			return this.convert((Map<?,?>) pObject);
		} else if (pObject instanceof Object[]) {
			return this.convert((Object[]) pObject);
		} else {
			return pObject;
		}
	}
	
	public ASkeleton parseSkeleton(Map<?, ?> pObject) throws InvalidSkeletonException {
		
		if ( pObject instanceof Map && pObject.size() == 2 
				&& pObject.containsKey("class") && pObject.containsKey("properties") 
				&& pObject.get("properties") instanceof Map ) {
				
			// it's a skeleton. Parse it
			Class<ASkeleton> sClass = this.getSkeletonFor(((String) pObject.get("class")));

			@SuppressWarnings("unchecked")
			Map<Object, Object> oProps = (Map<Object, Object>) pObject.get("properties");
			
			Map<String, Object> pProperties = new HashMap<String, Object>(oProps.size());
			
			for (Map.Entry<Object, Object> entry : oProps.entrySet() ) {
				// try to convert the properties
				pProperties.put(entry.getKey().toString(), this.convert(entry.getValue()));
			}
			
			return this.create(sClass, pProperties);
			
		} else {
			throw new InvalidSkeletonException();
		}
		
	}
	
	public Class<ASkeleton> getSkeletonFor(String skeletonName) throws InvalidSkeletonException {
		
		@SuppressWarnings("unchecked")
		Class<ASkeleton> theSkeleton = (Class<ASkeleton>) this.skeletons.get(skeletonName);
		
		if ( theSkeleton != null ) {
			return theSkeleton;
		} else {
			throw new InvalidSkeletonException(skeletonName);
		}
		
	}
	

}
