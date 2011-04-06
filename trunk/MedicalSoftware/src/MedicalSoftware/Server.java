package MedicalSoftware;

/*
 * @author Nathanial Heard
 * 
 */

import java.io.*;
import java.net.*;

class Server {

	static final int PORT = 5900; 
	static final String HOST = "cs2340.dyndns-server.com"; 

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		try {
			System.out.print("Sending data...\n");
			Socket skt = new Socket(HOST, PORT);
			
			DataInputStream input = new DataInputStream(skt.getInputStream());
			//PrintStream output = new PrintStream(skt.getOutputStream());
			
				System.out.println(input.readLine());

			input.close();
			//output.close();
			skt.close();

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
	}
}