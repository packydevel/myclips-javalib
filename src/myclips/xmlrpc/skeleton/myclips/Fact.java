
package myclips.xmlrpc.skeleton.myclips;

import java.util.Map;
import java.util.Vector;

import com.google.common.base.Joiner;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.rete.WME.WME skeleton
 *  
 * @author Francesco Capozzo
 */
public class Fact extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.Fact.Fact";

    protected Object templateName = null;
    protected Object moduleName = null;
    protected Object values = null;

    public Object getTemplateName() {
        return this.templateName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getTemplateName(Class<T> returnClass) {
        return (T) this.templateName;
    }

    public Fact setTemplateName(Object aValue) {
        this.templateName = aValue;
        return this;
    }
    
    public Object getModuleName() {
        return this.moduleName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getModuleName(Class<T> returnClass) {
        return (T) this.moduleName;
    }

    public Fact setModuleName(Object aValue) {
        this.moduleName = aValue;
        return this;
    }
    
    public Object getValues() {
        return this.values;
    }

    @SuppressWarnings("unchecked")
    public <T> T getValues(Class<T> returnClass) {
        return (T) this.values;
    }

    public Fact setValues(Object aValue) {
        this.values = aValue;
        return this;
    }

    @SuppressWarnings("unchecked")
	@Override
    public java.lang.String toString() {
    	if (this.templateName == null) { 
    		return java.lang.String.format("%s::(%s)", this.moduleName, Joiner.on(", ").join((Iterable<Object>) this.values)) ;
    	} else {
    		
    		java.lang.String[] slots = new java.lang.String[((Map<?, ?>)this.values).size()];
    		int i = 0;
    		for (Map.Entry<String, Object> vEntry: ((Map<String, Object>) this.values).entrySet() ) {
    			slots[i++] = java.lang.String.format("(%s %s)", vEntry.getKey(), vEntry.getValue());
    		}
    		
    		return java.lang.String.format("%s::(%s %s)", this.moduleName, this.templateName,
    				Joiner.on(" ").join((Object[]) slots)) ;
    	}
    }
    
}


