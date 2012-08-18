
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.Term skeleton
 *  
 * @author Francesco Capozzo
 */
public class Term extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.Term";

    protected Object term = null;


    public Object getTerm() {
        return this.term;
    }

    @SuppressWarnings("unchecked")
    public <T> T getTerm(Class<T> returnClass) {
        return (T) this.term;
    }

    public Term setTerm(Object aValue) {
        this.term = aValue;
        return this;
    }
    
    
    
}


