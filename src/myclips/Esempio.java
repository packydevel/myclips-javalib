package myclips;

import myclips.xmlrpc.stream.ConsoleOutputClientStream;

public class Esempio {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		JMyClipsExtended myclips = new JMyClipsExtended("http://localhost:8082/RPC2", "127.0.0.1");
		
		myclips.registerOutputResource("blabl", System.out, ConsoleOutputClientStream.class);

	}

}
