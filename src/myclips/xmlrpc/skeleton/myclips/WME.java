
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.rete.WME.WME skeleton
 *  
 * @author Francesco Capozzo
 */
public class WME extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.rete.WME.WME";

    protected Object fact = null;
    protected Object factId = null;

    public Object getFact() {
        return this.fact;
    }

    @SuppressWarnings("unchecked")
    public <T> T getFact(Class<T> returnClass) {
        return (T) this.fact;
    }

    public WME setFact(Object aValue) {
        this.fact = aValue;
        return this;
    }
    
    public Object getFactId() {
        return this.factId;
    }

    @SuppressWarnings("unchecked")
    public <T> T getFactId(Class<T> returnClass) {
        return (T) this.factId;
    }

    public WME setFactId(Object aValue) {
        this.factId = aValue;
        return this;
    }
    
    @Override
    public java.lang.String toString() {
    	return java.lang.String.format("<WME:Fact-%d, %s>", this.factId, this.fact) ;
    }
    
}


