package de.oio.jsf;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String vorname;
	private String name;
	private String email;
	private int alter;
	private List<Address> addresses = new ArrayList<Address>();
	
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		if (alter >= 18) {
			this.alter = alter;
		} 
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
