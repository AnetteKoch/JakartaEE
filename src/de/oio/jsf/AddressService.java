package de.oio.jsf;

import java.io.Serializable;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	@Transactional
	public List<Address> getAddresses(Long id) {
		Query query = entityManager.createQuery("SELECT a FROM Address a where a.person.id = :pe", Address.class);
		query.setParameter("pe", id);
		List<Address> addresses = query.getResultList();
		return addresses;
	}
	
	@Transactional
	public Address getAddress(Long id) {
		Address address = entityManager.find(Address.class, id);
		return address;
	}

}
