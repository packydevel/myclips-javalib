
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.TestPatternCE skeleton
 *  
 * @author Francesco Capozzo
 */
public class TestPatternCE extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.TestPatternCE";

    protected Object function = null;


    public Object getFunction() {
        return this.function;
    }

    @SuppressWarnings("unchecked")
    public <T> T getFunction(Class<T> returnClass) {
        return (T) this.function;
    }

    public TestPatternCE setFunction(Object aValue) {
        this.function = aValue;
        return this;
    }
    
    
    
}


