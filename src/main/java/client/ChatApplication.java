package client;

import java.io.IOException;
import java.net.UnknownHostException;

import lib.Action;
import lib.Connection;
import lib.Message;
import lib.Operation;
import lib.User;

public class ChatApplication {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		Action sendMessage = new Action(
										Operation.SEND, 
										new Message( 
												"Hello everybody!!!",
												new User("Writer"),
												new User("Reader")
												) 
										);
		
		System.out.println("CLIENT STARTING");
		// client ---> message --> server
		// client <--- message <--- server
		
		Connection connection = new Connection( "localhost", 7777 );
		
		
		connection.send( sendMessage );
		
		//////////////////////////////////////
		
		System.out.println( "Server sends: " + 
				connection.fetch()
				);
		
		connection.getSocket().close();
		System.out.println("CLIENT CLOSING");
	}

}
