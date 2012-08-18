
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.SlotDefinition skeleton
 *  
 * @author Francesco Capozzo
 */
public class SlotDefinition extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.SlotDefinition";

    protected Object slotName = null;
    protected Object attributes = null;


    public Object getSlotname() {
        return this.slotName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getSlotname(Class<T> returnClass) {
        return (T) this.slotName;
    }

    public SlotDefinition setSlotname(Object aValue) {
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

    public SlotDefinition setAttributes(Object aValue) {
        this.attributes = aValue;
        return this;
    }
    
    
    
}


