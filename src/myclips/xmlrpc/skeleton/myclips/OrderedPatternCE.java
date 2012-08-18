
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.OrderedPatternCE skeleton
 *  
 * @author Francesco Capozzo
 */
public class OrderedPatternCE extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.OrderedPatternCE";

    protected Object constraints = null;


    public Object getConstraints() {
        return this.constraints;
    }

    @SuppressWarnings("unchecked")
    public <T> T getConstraints(Class<T> returnClass) {
        return (T) this.constraints;
    }

    public OrderedPatternCE setConstraints(Object aValue) {
        this.constraints = aValue;
        return this;
    }
    
    
    
}


