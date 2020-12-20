package aspects;

import java.io.IOException;
import lib.Action;

public aspect LoggingAspect {

	pointcut whenSendingAction(): call( public void send(Object) throws IOException );
	
	before(): whenSendingAction() {
		
	    Action methodArg = (Action) thisJoinPoint.getArgs()[0];
	    
	    System.out.println("Sending " + methodArg.getType() + " request");
	}
	
	
	after() throwing (IOException e): whenSendingAction() {
		  
		System.out.println("Threw an exception: " + e);
	      }
	
	
	after(): whenSendingAction() {

		
		System.out.println("Request sent!");
	}
	
}
