
package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

/**
 * the myclips.parser.Types.FunctionCall skeleton
 *  
 * @author Francesco Capozzo
 */
public class FunctionCall extends ASkeleton {

    public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.FunctionCall";

    protected Object funcName = null;
    protected Object funcArgs = null;


    public Object getFuncname() {
        return this.funcName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getFuncname(Class<T> returnClass) {
        return (T) this.funcName;
    }

    public FunctionCall setFuncname(Object aValue) {
        this.funcName = aValue;
        return this;
    }
    
    public Object getFuncargs() {
        return this.funcArgs;
    }

    @SuppressWarnings("unchecked")
    public <T> T getFuncargs(Class<T> returnClass) {
        return (T) this.funcArgs;
    }

    public FunctionCall setFuncargs(Object aValue) {
        this.funcArgs = aValue;
        return this;
    }
    
    
    
}


