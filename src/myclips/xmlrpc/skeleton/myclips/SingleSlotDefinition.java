
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.SingleSlotDefinition skeleton
 *  
 * @author Francesco Capozzo
 */
public class SingleSlotDefinition extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.SingleSlotDefinition";

    protected Object slotName = null;
    protected Object attributes = null;


    public Object getSlotname() {
        return this.slotName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getSlotname(Class<T> returnClass) {
        return (T) this.slotName;
    }

    public SingleSlotDefinition setSlotname(Object aValue) {
        this.slotName = aValue;
        return this;
    }
    
    public Object getAttributes() {
        return this.attributes;
    }

    @SuppressWarnings("unchecked")
    public <T> T getAttributes(Class<T> returnClass) {
        return (T) this.attributes;
    }

    public SingleSlotDefinition setAttributes(Object aValue) {
        this.attributes = aValue;
        return this;
    }
    
    
    
}


