
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.TemplateRhsPattern skeleton
 *  
 * @author Francesco Capozzo
 */
public class TemplateRhsPattern extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.TemplateRhsPattern";

    protected Object templateName = null;
    protected Object templateSlots = null;


    public Object getTemplatename() {
        return this.templateName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getTemplatename(Class<T> returnClass) {
        return (T) this.templateName;
    }

    public TemplateRhsPattern setTemplatename(Object aValue) {
        this.templateName = aValue;
        return this;
    }
    
    public Object getTemplateslots() {
        return this.templateSlots;
    }

    @SuppressWarnings("unchecked")
    public <T> T getTemplateslots(Class<T> returnClass) {
        return (T) this.templateSlots;
    }

    public TemplateRhsPattern setTemplateslots(Object aValue) {
        this.templateSlots = aValue;
        return this;
    }
    
    
    
}


