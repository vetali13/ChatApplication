package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.Socket;
import lib.Action;
import lib.Connection;
import lib.Operation;
import lib.User;

public class ChatApplication {
	
	public static Map<Socket, User> users = new HashMap<>();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println(">>>SERVER STARTING");
		
		// create socket and wait for connections
		ServerSocket serverSocket = new ServerSocket(7777);
		Socket clientSocket = serverSocket.accept();
		Connection connection = new Connection( clientSocket );
		
		Action fetchedAction = (Action) connection.fetch();
		User user =  (User)fetchedAction.getTarget();
		
		switch (fetchedAction.getType()) {
		  case SIGNIN:
		    users.put(clientSocket, user );
		    connection.send(new Action(Operation.SUCCESS));
		    break;
		    
		  default:
			break;
		}
		
		/////////////////////////////////////////////
		
			fetchedAction = (Action) connection.fetch();
		
			switch (fetchedAction.getType()) {
			  case USERLIST:
				List<User> userList = new ArrayList<>();  
				users.forEach((k,v) -> userList.add(v));  
			    connection.send(new Action(Operation.SUCCESS, userList));
			    break;
	
			  default:
				break;
			}
		
		connection.getSocket().close();
		serverSocket.close();
		System.out.println(">>>SERVER ENDING");
	}

}
