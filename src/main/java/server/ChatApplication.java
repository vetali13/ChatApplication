package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import lib.Action;
import lib.Connection;
import lib.Message;
import lib.Operation;

public class ChatApplication {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println(">>>SERVER STARTING");
		
		// create socket and wait for connections
		ServerSocket serverSocket = new ServerSocket(7777);
		Connection connection = new Connection( serverSocket.accept() );
		
		Action sendMessage = (Action) connection.fetch();
		System.out.println( "Client sends: " + 
				sendMessage
				);
		
		/////////////////////////////////////////////
		connection.send(new Action(Operation.SEND,new Message("SERVER sends hello back")));
		
		connection.getSocket().close();
		serverSocket.close();
		System.out.println(">>>SERVER ENDING");
	}

}
