
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.ImportSpecification skeleton
 *  
 * @author Francesco Capozzo
 */
public class ImportSpecification extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.ImportSpecification";

    protected Object item = null;
    protected Object moduleName = null;


    public Object getItem() {
        return this.item;
    }

    @SuppressWarnings("unchecked")
    public <T> T getItem(Class<T> returnClass) {
        return (T) this.item;
    }

    public ImportSpecification setItem(Object aValue) {
        this.item = aValue;
        return this;
    }
    
    public Object getModulename() {
        return this.moduleName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getModulename(Class<T> returnClass) {
        return (T) this.moduleName;
    }

    public ImportSpecification setModulename(Object aValue) {
        this.moduleName = aValue;
        return this;
    }
    
    
    
}


