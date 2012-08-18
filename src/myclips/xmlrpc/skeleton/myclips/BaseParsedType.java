
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.BaseParsedType skeleton
 *  
 * @author Francesco Capozzo
 */
public class BaseParsedType extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.BaseParsedType";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public BaseParsedType setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


