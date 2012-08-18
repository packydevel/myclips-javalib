
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.FieldRhsSlot skeleton
 *  
 * @author Francesco Capozzo
 */
public class FieldRhsSlot extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.FieldRhsSlot";

    protected Object slotName = null;
    protected Object slotValue = null;


    public Object getSlotname() {
        return this.slotName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getSlotname(Class<T> returnClass) {
        return (T) this.slotName;
    }

    public FieldRhsSlot setSlotname(Object aValue) {
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

    public FieldRhsSlot setSlotvalue(Object aValue) {
        this.slotValue = aValue;
        return this;
    }
    
    
    
}


