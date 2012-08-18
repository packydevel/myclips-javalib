
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.FieldLhsSlot skeleton
 *  
 * @author Francesco Capozzo
 */
public class FieldLhsSlot extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.FieldLhsSlot";

    protected Object slotName = null;
    protected Object slotValue = null;


    public Object getSlotname() {
        return this.slotName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getSlotname(Class<T> returnClass) {
        return (T) this.slotName;
    }

    public FieldLhsSlot setSlotname(Object aValue) {
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

    public FieldLhsSlot setSlotvalue(Object aValue) {
        this.slotValue = aValue;
        return this;
    }
    
    
    
}


