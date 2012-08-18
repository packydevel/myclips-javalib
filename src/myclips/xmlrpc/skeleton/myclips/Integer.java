
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.Integer skeleton
 *  
 * @author Francesco Capozzo
 */
public class Integer extends Number {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.Integer";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public Integer setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


