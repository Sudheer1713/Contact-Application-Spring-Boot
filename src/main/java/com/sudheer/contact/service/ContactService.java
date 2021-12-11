/**
 * 
 */
package com.sudheer.contact.service;

import java.util.List;

import com.sudheer.contact.bindings.ContactForm;

/**
 * @author Sudheer
 *
 */

public interface ContactService {
	
	public String saveContact(ContactForm form);
	
	public List<ContactForm> viewContacts();
	
	public ContactForm editContact(Integer conatctId);
	
	public List<ContactForm> deleteContact(Integer conatctId);

}
