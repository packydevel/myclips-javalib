
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.DefaultAttribute skeleton
 *  
 * @author Francesco Capozzo
 */
public class DefaultAttribute extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.DefaultAttribute";

    protected Object defaultValue = null;


    public Object getDefaultvalue() {
        return this.defaultValue;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDefaultvalue(Class<T> returnClass) {
        return (T) this.defaultValue;
    }

    public DefaultAttribute setDefaultvalue(Object aValue) {
        this.defaultValue = aValue;
        return this;
    }
    
    
    
}


