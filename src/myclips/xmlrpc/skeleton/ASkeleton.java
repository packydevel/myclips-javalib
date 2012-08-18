package myclips.xmlrpc.skeleton;

import java.lang.reflect.Method;

import myclips.Utils;

public class ASkeleton implements ISkeleton {

	@Override
	public ISkeleton setField(String fieldName, Object fieldValue) {
		
		String methodName = "set" + Utils.ucFist(fieldName); 
		
		try {
			Object c = this.getClass();
			Method theMethod = this.getClass().getMethod(methodName, new Class<?>[]{Object.class});
			theMethod.invoke(this, fieldValue);
		} catch (Exception e) {
			// the method is not available, so ignore this call
		}
		
		return this;
	}
	
	public java.lang.String getSkeletonType() {
		try {
			return (String) this.getClass().getField("SKELETON_NAME").get(this.getClass());
		} catch (Exception e) {
			return "object";
		}
	}
	
	public static java.lang.String getSkeletonType( Class<? extends ASkeleton> aSkeleton ) {
		try {
			return (String) aSkeleton.getField("SKELETON_NAME").get(aSkeleton);
		} catch (Exception e) {
			return "object";
		}
	}
	

}
