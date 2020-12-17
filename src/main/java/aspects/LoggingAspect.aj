package aspects;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public aspect LoggingAspect {

	pointcut whenSendingMessage(): call( public void send(Object) throws IOException );
	
	before(): whenSendingMessage() {
		
	    Object methodArg = thisJoinPoint.getArgs()[0];
	    String messageBody = "";
	    
	    for( Method m : methodArg.getClass().getDeclaredMethods() ) {
			if( m.getName().compareToIgnoreCase( "getBody" )==0) {
				try {
					messageBody = (String) m.invoke(methodArg);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	    
		System.out.println("Sending message: " + messageBody);
	}
	
	
	after() throwing (IOException e): whenSendingMessage() {
		  
		System.out.println("Threw an exception: " + e);
	      }
	
	
	after(): whenSendingMessage() {

//		String methodArg = thisJoinPoint.getArgs()[0].toString();
		
		System.out.println("Message sent!");
	}
	
}
