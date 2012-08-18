package myclips;

/**
 * 
 * @author Francesco Capozzo
 *
 */
public abstract class Utils {

	public static Object[] concatArray(Object[] A, Object[] B) {
	   Object[] C= new Object[A.length+B.length];
	   System.arraycopy(A, 0, C, 0, A.length);
	   System.arraycopy(B, 0, C, A.length, B.length);
	   return C;
	}	
	
	public static Object[] prependTo(Object anElement, Object[] B) {
		return Utils.concatArray(new Object[]{anElement}, B);
	}
	
	public static String ucFist(String aString) {
		return aString.substring(0, 1).toUpperCase() + aString.substring(1);
	}
	
}
