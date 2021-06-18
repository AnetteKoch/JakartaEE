package de.oio.jsf;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@ApplicationScoped
@Named("personService")
public class PersonService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	EntityManager entityManager;
	
	Person person = new Person();
	
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Transactional
	public void savePerson(Person p) {
		setPerson(p);
		entityManager.persist(p);
	}

	@Transactional
	public void updatePerson(Person p) {
		entityManager.merge(p);
	}

}
