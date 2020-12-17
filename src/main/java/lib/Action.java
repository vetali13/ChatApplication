package lib;

import java.io.Serializable;

public class Action implements Serializable{
	private String name;

	public Action(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Action [name=" + name + "]";
	}
	
	

}
