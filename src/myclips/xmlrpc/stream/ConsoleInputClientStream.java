package myclips.xmlrpc.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Random;

public class ConsoleInputClientStream extends ClientStream {

	protected int theToken = 0;
	protected BufferedReader theStream = null;
	
	public ConsoleInputClientStream(InputStream aStream ) {
		theToken = new Random().nextInt();
		theStream = new BufferedReader(new InputStreamReader(aStream));
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
	}

	@Override
	public void writelines(int token, String[] sStrings) {
		this.assertValid(token);
	}

	@Override
	public void close(int token) {
		// ignore the close call
		//this.theStream.close();
		this.assertValid(token);
	}

	@Override
	public boolean seek(int token, int aPosition, int aMode) {
		this.assertValid(token);
		// ignore the call
		return false;
	}

	@Override
	public String readline(int token) {
		this.assertValid(token);
		try {
			return this.theStream.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public Object __call(int token, String missingMethod, Object... objects) {
		this.assertValid(token);
		return null;
	}
	
}
