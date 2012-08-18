
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.GlobalVariable skeleton
 *  
 * @author Francesco Capozzo
 */
public class GlobalVariable extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.GlobalVariable";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public GlobalVariable setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


