package lib;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {

	private Socket socket;

	public Connection(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public Connection(String host, Integer port) throws UnknownHostException, IOException {
		this( new Socket(host, port) );
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	// higher level logic
	
	public void send(Object object) throws IOException {
		ObjectOutputStream oout = new ObjectOutputStream( socket.getOutputStream() );
		oout.writeObject( object );
		oout.flush();
		
	}
	
	public Object fetch() throws IOException, ClassNotFoundException {
		ObjectInputStream oin = new ObjectInputStream( socket.getInputStream() );
		return oin.readObject();
	}
	
}
