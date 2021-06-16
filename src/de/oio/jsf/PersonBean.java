package de.oio.jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="personBean")
@SessionScoped
public class PersonBean implements Serializable {
	
	Person person = new Person();

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String submit() {
		String result = "details";
		if (person.getVorname() == null || person.getVorname().equals("") || person.getName()== null
				|| person.getName().equals("") || person.getAlter()== 0 || person.getEmail() == null || person.getEmail().equals("")) {
			result = null;
		}
		System.out.println(result);
		return result;
	}
	

}
