
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.Float skeleton
 *  
 * @author Francesco Capozzo
 */
public class Float extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.Float";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public Float setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


