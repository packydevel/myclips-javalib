package myclips.xmlrpc.skeleton.myclips;

import myclips.xmlrpc.skeleton.ASkeleton;

public abstract class BaseType extends ASkeleton {
	public static final java.lang.String SKELETON_NAME = "myclips.parser.Types.BaseParsedType";

    protected Object content = null;


    public Object getContent() {
        return this.content;
    }

    @SuppressWarnings("unchecked")
    public <T> T getContent(Class<T> returnClass) {
        return (T) this.content;
    }

    public BaseType setContent(Object aValue) {
        this.content = aValue;
        return this;
    }
    
	
	@Override
	public java.lang.String toString() {
		return java.lang.String.format("<%s:%s>", this.getClass().getSimpleName(), this.getContent());
	}
	
}
