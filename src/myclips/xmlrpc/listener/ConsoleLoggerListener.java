package myclips.xmlrpc.listener;

import java.util.HashMap;

import com.google.common.base.Joiner;

public class ConsoleLoggerListener extends ClientListener {

	@Override
	public boolean ping(int token) {
		this.assertValid(token);
		return true;
	}

	public void notify(Integer token, String anEventName, HashMap<?, ?> args) {
		this.assertValid(token);
		System.err.println(String.format("[Event: %s] %s", anEventName, args));
	}	
	
	@Override
	public void notify(Integer token, String anEventName, Object args) {
		this.assertValid(token);
		System.err.println(String.format("[Event: %s] %s", anEventName, args));
	}

	@Override
	public void close(int token) {
		System.err.println("CLOSE called on ConsoleLoggerListener");
	}

	@Override
	public void notify(Integer token, String anEventName, Object... args) {
		this.assertValid(token);
		System.err.println(String.format("[Event: %s] %s", anEventName, Joiner.on(", ").join((Object[]) args) ));
	}

}
