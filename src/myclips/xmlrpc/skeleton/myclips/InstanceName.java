
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.InstanceName skeleton
 *  
 * @author Francesco Capozzo
 */
public class InstanceName extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.InstanceName";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public InstanceName setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


