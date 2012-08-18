
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.PortItem skeleton
 *  
 * @author Francesco Capozzo
 */
public class PortItem extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.PortItem";

    protected Object portType = null;
    protected Object portNames = null;


    public Object getPorttype() {
        return this.portType;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPorttype(Class<T> returnClass) {
        return (T) this.portType;
    }

    public PortItem setPorttype(Object aValue) {
        this.portType = aValue;
        return this;
    }
    
    public Object getPortnames() {
        return this.portNames;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPortnames(Class<T> returnClass) {
        return (T) this.portNames;
    }

    public PortItem setPortnames(Object aValue) {
        this.portNames = aValue;
        return this;
    }
    
    
    
}


