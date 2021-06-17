package de.oio.jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named(value="personBean")
@SessionScoped
public class PersonBean implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
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
	
	public String modify() {
		String result = "modify";
		System.out.println(result);
		return result;
	}

	
	

}
