package myclips.xmlrpc.stream;

import java.io.StringWriter;
import java.util.Random;

public class FileOutputClientStream extends ClientStream {

	protected int theToken = 0;
	protected StringWriter theStream = null;
	
	public FileOutputClientStream(StringWriter aStream ) {
		theToken = new Random().nextInt();
		theStream = aStream;
	}
	
	public boolean assertValid(int token) {
		if ( this.theToken == token ) {
			return true;
		} else {
			throw new RuntimeException();
		}
	}
	
	public int getToken() {
		return this.theToken;
	}

	@Override
	public boolean ping(int token) {
		this.assertValid(token);
		return true;
	}

	@Override
	public void write(int token, String aString) {
		this.assertValid(token);
		this.theStream.write(aString);
	}

	@Override
	public void writelines(int token, String[] sStrings) {
		this.assertValid(token);
		for (String s : sStrings) {
			this.theStream.write(s);
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
