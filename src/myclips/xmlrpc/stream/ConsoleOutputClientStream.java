package myclips.xmlrpc.stream;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Random;

public class ConsoleOutputClientStream extends ClientStream {

	protected PrintStream theStream = null;
	
	public ConsoleOutputClientStream(PrintStream aStream ) {
		token = new Random().nextInt();
		theStream = aStream;
	}

	@Override
	public boolean ping(int token) {
		this.assertValid(token);
		return true;
	}

	@Override
	public void write(int token, String aString) {
		this.assertValid(token);
		this.theStream.print(aString);
	}

	@Override
	public void writelines(int token, String[] sStrings) {
		this.assertValid(token);
		for (String s : sStrings) {
			this.theStream.println(s);
		}
	}

	@Override
	public void close(int token) {
		// ignore the close call
		//this.theStream.close();
	}

	@Override
	public boolean seek(int token, int aPosition, int aMode) {
		// ignore the call
		return false;
	}

	@Override
	public String readline(int token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object __call(int token, String missingMethod, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
