
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.MultiFieldRhsSlot skeleton
 *  
 * @author Francesco Capozzo
 */
public class MultiFieldRhsSlot extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.MultiFieldRhsSlot";

    protected Object slotName = null;
    protected Object slotValue = null;


    public Object getSlotname() {
        return this.slotName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getSlotname(Class<T> returnClass) {
        return (T) this.slotName;
    }

    public MultiFieldRhsSlot setSlotname(Object aValue) {
        this.slotName = aValue;
        return this;
    }
    
    public Object getSlotvalue() {
        return this.slotValue;
    }

    @SuppressWarnings("unchecked")
    public <T> T getSlotvalue(Class<T> returnClass) {
        return (T) this.slotValue;
    }

    public MultiFieldRhsSlot setSlotvalue(Object aValue) {
        this.slotValue = aValue;
        return this;
    }
    
    
    
}


