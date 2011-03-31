package MedicalSoftware;

/*
 * @author Nathanial Heard
 * 
 */

//import java.sql.*; 

// Used for url transferring
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

class Server { 

public static void main (String[] args) { 
	String location = "ftp://shade34321:millcreek@cs2340.dyndns-server.com";
	BufferedReader input;
	Socket socket;
	URL url;
    try
    {
    	url = new URL(location);
    	socket = new Socket(url.getHost(), 2341); 
    	System.out.println(socket.isBound());
    	System.out.println(socket.isConnected());
    	System.out.println(socket.getInetAddress());
    	System.out.print("Works!");
    	socket.close();
    	
    }
    catch (Exception e)
    {
      System.err.println("Exception!"); 
      System.err.println(e.getMessage()); 
    } 
  } 
} 
