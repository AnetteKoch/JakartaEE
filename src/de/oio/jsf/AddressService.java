package de.oio.jsf;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@ApplicationScoped
@Named("addressService")
public class AddressService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	EntityManager entityManager;

	@Transactional
	public void saveAddress(Address ad) {
		entityManager.persist(ad);
	}

	@Transactional
	public void updateAddress(Address ad) {
		entityManager.merge(ad);
	}

}
