
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.Constraint skeleton
 *  
 * @author Francesco Capozzo
 */
public class Constraint extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.Constraint";

    protected Object constraint = null;


    public Object getConstraint() {
        return this.constraint;
    }

    @SuppressWarnings("unchecked")
    public <T> T getConstraint(Class<T> returnClass) {
        return (T) this.constraint;
    }

    public Constraint setConstraint(Object aValue) {
        this.constraint = aValue;
        return this;
    }
    
    
    
}


