package de.oio.jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "addressBean")
@SessionScoped
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String submit() {
		String result = "indexWithAddress";
		if (address.getCity() == "" || address.getCity().equals(null) || address.getStreet() == ""
				|| address.getStreet().equals(null) || address.getZip() == 0) {
			result = null;
		}
		address.setPerson(personService.getPerson());
		System.out.println(address.getPerson().toString());
		addressService.saveAddress(address);
		System.out.println(result);
		return result;
	}

	public String modify() {
		String result = "modify";
		System.out.println(result);
		return result;
	}

}