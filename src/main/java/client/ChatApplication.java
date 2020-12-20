package client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;
import lib.Action;
import lib.Connection;
import lib.Operation;
import lib.User;

public class ChatApplication {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		System.out.println("CLIENT STARTING");
		// client ---> message --> server
		// client <--- message <--- server
		
		// Reading the username from keyboard
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter username");
		String userName = scanner.nextLine();  // Read user input
		scanner.close();
		
		User user = new User( userName ); 
		
		Action action = new Action(Operation.SIGNIN, user);
		
		Connection connection = new Connection( "localhost", 7777 );
		
		connection.send( action );
		
		//////////////////////////////////////
		Action fetchedAction = (Action) connection.fetch();
		
		switch (fetchedAction.getType()) {
		  case SUCCESS:
		   System.out.println("Signed in");
		    break;
		  
		  default:
			break;
		}
		
		connection.send(new Action(Operation.USERLIST));
		
		fetchedAction = (Action) connection.fetch();
		
		switch (fetchedAction.getType()) {
		  case SUCCESS:
			List<User> users = (List<User>) fetchedAction.getTarget();
			users.forEach(u -> System.out.println(u));
		    break;
		  
		  default:
			break;
		}
		
		
		connection.getSocket().close();
		System.out.println("CLIENT CLOSING");
	}

}
