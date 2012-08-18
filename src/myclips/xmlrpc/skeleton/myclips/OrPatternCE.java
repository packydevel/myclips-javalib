
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.OrPatternCE skeleton
 *  
 * @author Francesco Capozzo
 */
public class OrPatternCE extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.OrPatternCE";

    protected Object patterns = null;


    public Object getPatterns() {
        return this.patterns;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPatterns(Class<T> returnClass) {
        return (T) this.patterns;
    }

    public OrPatternCE setPatterns(Object aValue) {
        this.patterns = aValue;
        return this;
    }
    
    
    
}


