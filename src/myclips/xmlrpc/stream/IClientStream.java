package myclips.xmlrpc.stream;

public interface IClientStream {

	public boolean ping(int token);
	public void write(int token, String aString);
	public void writelines(int token, String[] sStrings);
	public void close(int token);
	public boolean seek(int token, int aPosition, int aMode);
	public String readline(int token);
	public Object __call(int token, String missingMethod, Object...objects );
	
	
}
