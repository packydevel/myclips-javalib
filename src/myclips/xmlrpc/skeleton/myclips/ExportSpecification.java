
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.ExportSpecification skeleton
 *  
 * @author Francesco Capozzo
 */
public class ExportSpecification extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.ExportSpecification";

    protected Object item = null;


    public Object getItem() {
        return this.item;
    }

    @SuppressWarnings("unchecked")
    public <T> T getItem(Class<T> returnClass) {
        return (T) this.item;
    }

    public ExportSpecification setItem(Object aValue) {
        this.item = aValue;
        return this;
    }
    
    
    
}


