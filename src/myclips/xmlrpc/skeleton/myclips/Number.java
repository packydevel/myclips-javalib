
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.Number skeleton
 *  
 * @author Francesco Capozzo
 */
public class Number extends BaseType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.Number";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public Number setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


