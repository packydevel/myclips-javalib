
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.UnnamedSingleFieldVariable skeleton
 *  
 * @author Francesco Capozzo
 */
public class UnnamedSingleFieldVariable extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.UnnamedSingleFieldVariable";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public UnnamedSingleFieldVariable setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


