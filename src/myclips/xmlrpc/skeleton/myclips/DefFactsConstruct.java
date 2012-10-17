
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.DefFactsConstruct skeleton
 *  
 * @author Francesco Capozzo
 */
public class DefFactsConstruct extends MyClipsConstruct {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.DefFactsConstruct";

    protected Object deffactsName = null;
    protected Object deffactsComment = null;
    protected Object rhs = null;


    public Object getDeffactsname() {
        return this.deffactsName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDeffactsname(Class<T> returnClass) {
        return (T) this.deffactsName;
    }

    public DefFactsConstruct setDeffactsname(Object aValue) {
        this.deffactsName = aValue;
        return this;
    }
    
    public Object getDeffactscomment() {
        return this.deffactsComment;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDeffactscomment(Class<T> returnClass) {
        return (T) this.deffactsComment;
    }

    public DefFactsConstruct setDeffactscomment(Object aValue) {
        this.deffactsComment = aValue;
        return this;
    }
    
    public Object getRhs() {
        return this.rhs;
    }

    @SuppressWarnings("unchecked")
    public <T> T getRhs(Class<T> returnClass) {
        return (T) this.rhs;
    }

    public DefFactsConstruct setRhs(Object aValue) {
        this.rhs = aValue;
        return this;
    }
    
    
    
}


