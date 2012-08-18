
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.ConnectedConstraint skeleton
 *  
 * @author Francesco Capozzo
 */
public class ConnectedConstraint extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.ConnectedConstraint";

    protected Object constraint = null;
    protected Object connectedConstraints = null;


    public Object getConstraint() {
        return this.constraint;
    }

    @SuppressWarnings("unchecked")
    public <T> T getConstraint(Class<T> returnClass) {
        return (T) this.constraint;
    }

    public ConnectedConstraint setConstraint(Object aValue) {
        this.constraint = aValue;
        return this;
    }
    
    public Object getConnectedconstraints() {
        return this.connectedConstraints;
    }

    @SuppressWarnings("unchecked")
    public <T> T getConnectedconstraints(Class<T> returnClass) {
        return (T) this.connectedConstraints;
    }

    public ConnectedConstraint setConnectedconstraints(Object aValue) {
        this.connectedConstraints = aValue;
        return this;
    }
    
    
    
}


