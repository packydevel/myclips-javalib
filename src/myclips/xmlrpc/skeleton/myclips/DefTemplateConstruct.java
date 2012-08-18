
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.DefTemplateConstruct skeleton
 *  
 * @author Francesco Capozzo
 */
public class DefTemplateConstruct extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.DefTemplateConstruct";

    protected Object templateName = null;
    protected Object templateComment = null;
    protected Object slots = null;


    public Object getTemplatename() {
        return this.templateName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getTemplatename(Class<T> returnClass) {
        return (T) this.templateName;
    }

    public DefTemplateConstruct setTemplatename(Object aValue) {
        this.templateName = aValue;
        return this;
    }
    
    public Object getTemplatecomment() {
        return this.templateComment;
    }

    @SuppressWarnings("unchecked")
    public <T> T getTemplatecomment(Class<T> returnClass) {
        return (T) this.templateComment;
    }

    public DefTemplateConstruct setTemplatecomment(Object aValue) {
        this.templateComment = aValue;
        return this;
    }
    
    public Object getSlots() {
        return this.slots;
    }

    @SuppressWarnings("unchecked")
    public <T> T getSlots(Class<T> returnClass) {
        return (T) this.slots;
    }

    public DefTemplateConstruct setSlots(Object aValue) {
        this.slots = aValue;
        return this;
    }
    
    
    
}


