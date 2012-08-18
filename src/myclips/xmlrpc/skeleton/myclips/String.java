
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.String skeleton
 *  
 * @author Francesco Capozzo
 */
public class String extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.String";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public String setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


