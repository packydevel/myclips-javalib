
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.TypeAttribute skeleton
 *  
 * @author Francesco Capozzo
 */
public class TypeAttribute extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.TypeAttribute";

    protected Object allowedTypes = null;


    public Object getAllowedtypes() {
        return this.allowedTypes;
    }

    @SuppressWarnings("unchecked")
    public <T> T getAllowedtypes(Class<T> returnClass) {
        return (T) this.allowedTypes;
    }

    public TypeAttribute setAllowedtypes(Object aValue) {
        this.allowedTypes = aValue;
        return this;
    }
    
    
    
}


