package de.oio.jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
@Named
public class Resources {
	
	@Produces
	@PersistenceContext(unitName="personDatabase")
	static EntityManager entityManager;
	
	

}
