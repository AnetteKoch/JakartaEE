package de.oio.jsf;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String vorname;
	private String name;
	private String email;
	private int alter = 25;
	private List<Address> addresses;
	
	
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
		addresses = new ArrayList<Address>();
		Address address1 = new Address();
		address1.setCity("Mannheim");
		address1.setStreet("Hauptstraße");
		address1.setZip(60126);
		
		Address address2 = new Address();
		address2.setCity("Heidelberg");
		address2.setStreet("Hauptstraße");
		address2.setZip(60126);
		
		this.addresses.add(address1);
		this.addresses.add(address2);
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
