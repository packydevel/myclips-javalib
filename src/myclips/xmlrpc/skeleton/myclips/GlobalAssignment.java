
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.GlobalAssignment skeleton
 *  
 * @author Francesco Capozzo
 */
public class GlobalAssignment extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.GlobalAssignment";

    protected Object variable = null;
    protected Object value = null;
    protected Object runningValue = null;


    public Object getVariable() {
        return this.variable;
    }

    @SuppressWarnings("unchecked")
    public <T> T getVariable(Class<T> returnClass) {
        return (T) this.variable;
    }

    public GlobalAssignment setVariable(Object aValue) {
        this.variable = aValue;
        return this;
    }
    
    public Object getValue() {
        return this.value;
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue(Class<T> returnClass) {
        return (T) this.value;
    }

    public GlobalAssignment setValue(Object aValue) {
        this.value = aValue;
        return this;
    }
    
    public Object getRunningvalue() {
        return this.runningValue;
    }

    @SuppressWarnings("unchecked")
    public <T> T getRunningvalue(Class<T> returnClass) {
        return (T) this.runningValue;
    }

    public GlobalAssignment setRunningvalue(Object aValue) {
        this.runningValue = aValue;
        return this;
    }
    
    
    
}


