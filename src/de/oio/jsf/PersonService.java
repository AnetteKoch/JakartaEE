package de.oio.jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@ApplicationScoped
@Named("personService")
public class PersonService {
	
	@Inject
	EntityManager entityManager;
	
	public void savePerson(Person p) {
		entityManager.persist(p);
	}

}
