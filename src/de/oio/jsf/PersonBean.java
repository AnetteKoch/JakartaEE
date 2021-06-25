package de.oio.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "personBean")
@ApplicationScoped
public class PersonBean implements Serializable {

	@Inject
	PersonService personService;

	private static final long serialVersionUID = 1L;
	Person person = new Person();

	private List<String> names;
	private String selectedItem;
	
	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

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
		if (person.getId() == null) {
			this.personService.savePerson(person);
			setNames(personService.getPersonName());
		} else {
			this.personService.updatePerson(person);
			setNames(personService.getPersonName());
		}
		System.out.println(result);
		System.out.println(names.toString());
		return result;
	}

	public String modify() {
		String result = "modifyPerson";
		System.out.println(result);
		return result;
	}

	public String create() {
		String result = "create";
		person = new Person();
		System.out.println(result);
		return result;
	}

	public String addAddress() {
		this.submit();
		personService.setPerson(person);
		String result = "address";
		System.out.println(result);
		return result;
	}
	
	public String show() {
		this.person = personService.getPersonbyId(Long.parseLong(selectedItem.substring(0, 1))); 
		String result = "show";
		System.out.println(result);
		return result;
	}

	/*
	 * public List<SelectItem> setOptions() { List<SelectItem> items = new
	 * ArrayList<SelectItem>(); for (int i = 0; i < this.names.size(); i++) {
	 * items.add(new SelectItem(this.names.get(i))); } return items; }
	 */
}
