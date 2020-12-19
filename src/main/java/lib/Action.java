package lib;

import java.io.Serializable;

public class Action implements Serializable{
	private Operation type;
	private Object target;
	
	public Action(Operation type, Object target) {
		super();
		this.setType(type);
		this.setTarget(target);
	}

	public void setType(Operation type) {
		this.type = type;
	}

	public Operation getType() {
		return type;
	}

	public void setName(Operation type) {
		this.type = type;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "Action [type=" + type + ", target=" + target + "]";
	}

}
