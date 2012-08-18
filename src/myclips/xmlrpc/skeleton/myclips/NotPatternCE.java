
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.NotPatternCE skeleton
 *  
 * @author Francesco Capozzo
 */
public class NotPatternCE extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.NotPatternCE";

    protected Object pattern = null;


    public Object getPattern() {
        return this.pattern;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPattern(Class<T> returnClass) {
        return (T) this.pattern;
    }

    public NotPatternCE setPattern(Object aValue) {
        this.pattern = aValue;
        return this;
    }
    
    
    
}


