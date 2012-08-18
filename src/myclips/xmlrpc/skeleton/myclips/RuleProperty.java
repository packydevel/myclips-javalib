
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.RuleProperty skeleton
 *  
 * @author Francesco Capozzo
 */
public class RuleProperty extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.RuleProperty";

    protected Object propertyName = null;
    protected Object propertyValue = null;


    public Object getPropertyname() {
        return this.propertyName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPropertyname(Class<T> returnClass) {
        return (T) this.propertyName;
    }

    public RuleProperty setPropertyname(Object aValue) {
        this.propertyName = aValue;
        return this;
    }
    
    public Object getPropertyvalue() {
        return this.propertyValue;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPropertyvalue(Class<T> returnClass) {
        return (T) this.propertyValue;
    }

    public RuleProperty setPropertyvalue(Object aValue) {
        this.propertyValue = aValue;
        return this;
    }
    
    
    
}


