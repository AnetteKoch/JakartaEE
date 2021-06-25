package de.oio.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ApplicationScoped
@Named("personService")
public class PersonService implements Serializable {

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
	
	public Person getPersonbyId(Long id) {
		Query query = entityManager.createQuery("select p from Person p where p.id = :pe", Person.class);
		query.setParameter("pe", id);
		return (Person) query.getResultList();
	}

	public List<String> getPersonName() {
		Query queryId = entityManager.createQuery("SELECT p.id FROM Person p", Long.class);
		List<Long> personId = queryId.getResultList();
		Query queryName = entityManager.createQuery("SELECT p.name FROM Person p", String.class);
		List<String> personLastNames = queryName.getResultList();
		Query query = entityManager.createQuery("SELECT p.vorname FROM Person p", String.class);
		List<String> personFirstNames = query.getResultList();
		List<String> personFullName = new ArrayList<String>();
		for (int i = 0; i < personLastNames.size(); i++) {
			personFullName.add(personId.get(i)+ " - " + personLastNames.get(i) + ", " + personFirstNames.get(i));
		}
		return personFullName;
	}

}
