package client;

import java.io.IOException;
import java.net.UnknownHostException;
import lib.Connection;
import lib.Message;
import lib.User;

public class ChatApplication {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		System.out.println("CLIENT STARTING");
		// client ---> message --> server
		// client <--- message <--- server
		
		Connection connection = new Connection( "localhost", 7777 );
		
		Message message = new Message( "Hello server" );
		message.setFrom( new User("Author") );
		message.setTo( new User("Reader") );
		
		connection.send( message );
		
		//////////////////////////////////////
		
		System.out.println( "Server sends: " + 
				connection.fetch()
				);
		
		connection.getSocket().close();
		System.out.println("CLIENT CLOSING");
	}

}
