
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.SingleFieldVariable skeleton
 *  
 * @author Francesco Capozzo
 */
public class SingleFieldVariable extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.SingleFieldVariable";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public SingleFieldVariable setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


