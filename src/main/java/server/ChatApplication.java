package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import lib.Connection;
import lib.Message;

public class ChatApplication {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println(">>>SERVER STARTING");
		
		// create socket and wait for connections
		ServerSocket serverSocket = new ServerSocket(7777);
		Connection connection = new Connection( serverSocket.accept() );
		
		System.out.println( "Client sends: " + 
				connection.fetch()
				);
		
		/////////////////////////////////////////////
		connection.send(new Message("SERVER sends hello back"));
		
		connection.getSocket().close();
		serverSocket.close();
		System.out.println(">>>SERVER ENDING");
	}

}
