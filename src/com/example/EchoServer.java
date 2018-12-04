/* 
***************************************************************************************************
*****************************
* @author Ahmed Abdellatif  *
*****************************
*  Referenced: https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/SocketProgramming/SocketProgram.html#section2
*  
*  Here's an overview of how to create the simple server program:
*  1. Create and open a server socket.
*  2. Wait for the client request.
*  3. Open an input stream and an output stream to the client.
*  4. Communicate with the client.
*  5. Close the streams and then close the socket.
*
 **************************************************************************************************
 */
package com.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EchoServer {

   public static void main(String[] args) throws IOException {

	 if (args.length < 1) {
	    System.err.println("Usage: java EchoServer <port number>");
	    System.exit(1);
	 }
	 System.out.println("Server started. Listening on Port 8005");

	 /**
	  * portNumber argument represents the logical address through which the application communicates over 
	  * the network
	  */
	 int portNumber = Integer.parseInt(args[0]);
	 
	 // Create and Open a Server Socket
	 try (ServerSocket serverSocket = new ServerSocket(portNumber);
		 Socket clientSocket = serverSocket.accept(); // wait for the client request to respond

		 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		 // create buffered reader
		 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

	    //print out that we are connected on the port and echo port number
	    System.out.println("Client Connected on Port " + portNumber + ". Servicing Requests.");
	    String inputLine;

	    // reader while there is input found
	    while ((inputLine = in.readLine()) != null) {
		  System.out.println("Received message: " + inputLine + "from " + clientSocket.toString());
		  out.println(inputLine);
	    }
	 } catch (IOException e) {
	    System.out.println("Exception caught when trying to listen on port "
		    + portNumber + " or listening for a connection");
	 }

   }

}
