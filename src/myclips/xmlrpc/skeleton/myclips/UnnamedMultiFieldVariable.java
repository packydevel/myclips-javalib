
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.UnnamedMultiFieldVariable skeleton
 *  
 * @author Francesco Capozzo
 */
public class UnnamedMultiFieldVariable extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.UnnamedMultiFieldVariable";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public UnnamedMultiFieldVariable setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


