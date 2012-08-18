
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.DefFunctionConstruct skeleton
 *  
 * @author Francesco Capozzo
 */
public class DefFunctionConstruct extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.DefFunctionConstruct";

    protected Object functionName = null;
    protected Object comment = null;
    protected Object params = null;
    protected Object actions = null;


    public Object getFunctionname() {
        return this.functionName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getFunctionname(Class<T> returnClass) {
        return (T) this.functionName;
    }

    public DefFunctionConstruct setFunctionname(Object aValue) {
        this.functionName = aValue;
        return this;
    }
    
    public Object getComment() {
        return this.comment;
    }

    @SuppressWarnings("unchecked")
    public <T> T getComment(Class<T> returnClass) {
        return (T) this.comment;
    }

    public DefFunctionConstruct setComment(Object aValue) {
        this.comment = aValue;
        return this;
    }
    
    public Object getParams() {
        return this.params;
    }

    @SuppressWarnings("unchecked")
    public <T> T getParams(Class<T> returnClass) {
        return (T) this.params;
    }

    public DefFunctionConstruct setParams(Object aValue) {
        this.params = aValue;
        return this;
    }
    
    public Object getActions() {
        return this.actions;
    }

    @SuppressWarnings("unchecked")
    public <T> T getActions(Class<T> returnClass) {
        return (T) this.actions;
    }

    public DefFunctionConstruct setActions(Object aValue) {
        this.actions = aValue;
        return this;
    }
    
    
    
}


