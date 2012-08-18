
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.DefGlobalConstruct skeleton
 *  
 * @author Francesco Capozzo
 */
public class DefGlobalConstruct extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.DefGlobalConstruct";

    protected Object moduleName = null;
    protected Object assignments = null;


    public Object getModulename() {
        return this.moduleName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getModulename(Class<T> returnClass) {
        return (T) this.moduleName;
    }

    public DefGlobalConstruct setModulename(Object aValue) {
        this.moduleName = aValue;
        return this;
    }
    
    public Object getAssignments() {
        return this.assignments;
    }

    @SuppressWarnings("unchecked")
    public <T> T getAssignments(Class<T> returnClass) {
        return (T) this.assignments;
    }

    public DefGlobalConstruct setAssignments(Object aValue) {
        this.assignments = aValue;
        return this;
    }
    
    
    
}


