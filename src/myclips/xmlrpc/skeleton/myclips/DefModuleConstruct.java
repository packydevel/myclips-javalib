
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.DefModuleConstruct skeleton
 *  
 * @author Francesco Capozzo
 */
public class DefModuleConstruct extends MyClipsConstruct {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.DefModuleConstruct";

    protected Object moduleName = null;
    protected Object comment = null;
    protected Object specifications = null;


    public Object getModulename() {
        return this.moduleName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getModulename(Class<T> returnClass) {
        return (T) this.moduleName;
    }

    public DefModuleConstruct setModulename(Object aValue) {
        this.moduleName = aValue;
        return this;
    }
    
    public Object getComment() {
        return this.comment;
    }

    @SuppressWarnings("unchecked")
    public <T> T getComment(Class<T> returnClass) {
        return (T) this.comment;
    }

    public DefModuleConstruct setComment(Object aValue) {
        this.comment = aValue;
        return this;
    }
    
    public Object getSpecifications() {
        return this.specifications;
    }

    @SuppressWarnings("unchecked")
    public <T> T getSpecifications(Class<T> returnClass) {
        return (T) this.specifications;
    }

    public DefModuleConstruct setSpecifications(Object aValue) {
        this.specifications = aValue;
        return this;
    }
    
    
    
}


