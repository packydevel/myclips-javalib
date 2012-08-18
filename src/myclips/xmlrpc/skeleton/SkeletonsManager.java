package myclips.xmlrpc.skeleton;

import java.util.Map;

public class SkeletonsManager {
	
	public <T extends ASkeleton> T create(Class<T> aSkeletonClass ) throws InvalidSkeletonException {
		try {
			return aSkeletonClass.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new InvalidSkeletonException("Invalid skeleton: "+aSkeletonClass);
		}
	}
	
	public <T extends ASkeleton> T create(Class<T> aSkeletonClass, Map<String, Object> args ) throws InvalidSkeletonException {
		T theSkeleton = this.create(aSkeletonClass);
		
		for (Map.Entry<String, Object> entry : args.entrySet()) {
		    theSkeleton.setField(entry.getKey(), entry.getValue());
		}
		
		return theSkeleton;
	}
	

}
