package de.oio.jsf;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named(value = "personBean")
@ApplicationScoped
public class PersonBean implements Serializable {

	@Inject
	PersonService personService;

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
		if ((person.getVorname() == null || person.getVorname().equals("") || person.getName() == null
				|| person.getName().equals("") || person.getAlter() == 0 || person.getEmail() == null
				|| person.getEmail().equals(""))) {
			result = null;
		}
		if(person.getId()== null) {
			this.personService.savePerson(person);
		}
		else {
			this.personService.updatePerson(person);
		}
		System.out.println(result);
		return result;
	}

	public String modify() {
		String result = "modify";
		System.out.println(result);
		return result;
	}
	
	public String create() {
		String result="create";
		person = new Person();
		System.out.println(result);
		return result;
	}
	
	public String addAddress() {
		this.submit();
		personService.setPerson(person);
		String result ="address";
		System.out.println(result);
		return result;
	}
}
