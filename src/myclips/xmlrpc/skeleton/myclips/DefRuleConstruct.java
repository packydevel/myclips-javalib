
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.DefRuleConstruct skeleton
 *  
 * @author Francesco Capozzo
 */
public class DefRuleConstruct extends MyClipsConstruct {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.DefRuleConstruct";

    protected Object defruleName = null;
    protected Object defruleComment = null;
    protected Object defruleDeclaration = null;
    protected Object lhs = null;
    protected Object rhs = null;


    public Object getDefrulename() {
        return this.defruleName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDefrulename(Class<T> returnClass) {
        return (T) this.defruleName;
    }

    public DefRuleConstruct setDefrulename(Object aValue) {
        this.defruleName = aValue;
        return this;
    }
    
    public Object getDefrulecomment() {
        return this.defruleComment;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDefrulecomment(Class<T> returnClass) {
        return (T) this.defruleComment;
    }

    public DefRuleConstruct setDefrulecomment(Object aValue) {
        this.defruleComment = aValue;
        return this;
    }
    
    public Object getDefruledeclaration() {
        return this.defruleDeclaration;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDefruledeclaration(Class<T> returnClass) {
        return (T) this.defruleDeclaration;
    }

    public DefRuleConstruct setDefruledeclaration(Object aValue) {
        this.defruleDeclaration = aValue;
        return this;
    }
    
    public Object getLhs() {
        return this.lhs;
    }

    @SuppressWarnings("unchecked")
    public <T> T getLhs(Class<T> returnClass) {
        return (T) this.lhs;
    }

    public DefRuleConstruct setLhs(Object aValue) {
        this.lhs = aValue;
        return this;
    }
    
    public Object getRhs() {
        return this.rhs;
    }

    @SuppressWarnings("unchecked")
    public <T> T getRhs(Class<T> returnClass) {
        return (T) this.rhs;
    }

    public DefRuleConstruct setRhs(Object aValue) {
        this.rhs = aValue;
        return this;
    }
    
    
    
}


