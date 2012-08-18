
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.AssignedPatternCE skeleton
 *  
 * @author Francesco Capozzo
 */
public class AssignedPatternCE extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.AssignedPatternCE";

    protected Object variable = null;
    protected Object pattern = null;


    public Object getVariable() {
        return this.variable;
    }

    @SuppressWarnings("unchecked")
    public <T> T getVariable(Class<T> returnClass) {
        return (T) this.variable;
    }

    public AssignedPatternCE setVariable(Object aValue) {
        this.variable = aValue;
        return this;
    }
    
    public Object getPattern() {
        return this.pattern;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPattern(Class<T> returnClass) {
        return (T) this.pattern;
    }

    public AssignedPatternCE setPattern(Object aValue) {
        this.pattern = aValue;
        return this;
    }
    
    
    
}


