package de.oio.jsf;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;

@Named(value = "addressBean")
@RequestScoped
public class AddressBean implements Serializable {

	/**
	 * 
	 */
	@Inject
	AddressService addressService;
	
	@Inject
	PersonService personService;

	private static final long serialVersionUID = 1L;
	Address address = new Address();
	
	@Inject
	private PersonBean personBean;
	
	public Address getAddress() {
		return address;
	}
	
	Person person;

	public void setAddress(Address address) {
		this.address = address;
	}

	public String submit() {
		String result = "indexWithAddress";
		if (address.getCity() == "" || address.getCity().equals(null) || address.getStreet() == ""
				|| address.getStreet().equals(null) || address.getZip() == 0) {
			result = null;
		}
		Person person = personBean.getPerson();
		address.setPerson(personService.getPerson());
		System.out.println(address.getPerson().getAddresses());
		if(person.getAddresses().size() > 0) {
		address.setId(person.getAddresses().get(Math.toIntExact(person.getId())-1).getId());
		}
		if(address.getId()== null) {
			address.getPerson().getAddresses().add(address);
			this.addressService.saveAddress(address);
		}
		else {
			this.addressService.updateAddress(address);
		}		
		System.out.println(result);
		return result;
	}

	public String modify() {
		Person person = personBean.getPerson();
		address.setPerson(personService.getPerson());
		System.out.println(person.getId());
		this.setAddress(person.getAddresses().get(Math.toIntExact(person.getId())-1));
		String result = "modifyAddress";
		System.out.println(result);
		return result;
	}

}
