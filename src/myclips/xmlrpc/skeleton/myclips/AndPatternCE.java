
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.AndPatternCE skeleton
 *  
 * @author Francesco Capozzo
 */
public class AndPatternCE extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.AndPatternCE";

    protected Object patterns = null;


    public Object getPatterns() {
        return this.patterns;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPatterns(Class<T> returnClass) {
        return (T) this.patterns;
    }

    public AndPatternCE setPatterns(Object aValue) {
        this.patterns = aValue;
        return this;
    }
    
    
    
}


