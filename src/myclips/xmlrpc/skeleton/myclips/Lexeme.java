
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.Lexeme skeleton
 *  
 * @author Francesco Capozzo
 */
public class Lexeme extends MyClipsType {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.Lexeme";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public Lexeme setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
    
    
}


