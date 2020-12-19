package lib;

import java.io.Serializable;

public class Message implements Serializable {
	
	private String body;
	private User from;
	private User to;

	public Message(String body) {
		super();
		this.body = body;
	}
	
	public Message(String body, User from, User to) {
		super();
		this.body = body;
		setFrom(from);
		setTo(to);
	}




	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Message ["
				+ "from: " + from + "\n"
				+ "to: " + to + "\n"
				+ "body=" + body + "\n"
				+ "]";
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	
}
