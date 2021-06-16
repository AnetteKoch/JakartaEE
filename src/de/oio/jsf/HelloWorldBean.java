/**
 * 
 */
package de.oio.jsf;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author owolff
 *
 */
//@ManagedBean(name = "helloBean")
@Named("helloBean")
@SessionScoped
public class HelloWorldBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "This Page was created using JavaServer Faces";
	private String helloString = MESSAGE;
	

	/**
	 * @return
	 */
	public String getHelloString() {
		return helloString;
	}

	/**
	 * @param helloString
	 */
	public void setHelloString(String helloString) {
		System.out.println("setHelloString called");
		this.helloString = helloString;
	}
	
	/**
	 * @return String represantation of the actual time
	 */
	public String getActualTime() {
		System.out.println("getActualTime called");
		SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss", Locale.GERMAN);
		return formater.format(System.currentTimeMillis());
	}
	
	/**
	 * @return
	 */
	public String resetMessage() {
		System.out.println("resetMessage called");
		helloString = MESSAGE;
		return "success";
	}
}
