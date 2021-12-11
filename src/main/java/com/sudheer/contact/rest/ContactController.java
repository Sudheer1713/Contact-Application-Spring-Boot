/**
 * 
 */
package com.sudheer.contact.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.contact.bindings.ContactForm;
import com.sudheer.contact.service.ContactService;

/**
 * @author Sudheer
 *
 */
@RestController
public class ContactController {

	@Autowired
	private ContactService service;

	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {

		String status = service.saveContact(form);
		return status;

	}

	@GetMapping("/viewContacs")
	public List<ContactForm> viewContacts() {

		List<ContactForm> contacts = service.viewContacts();

		return contacts;

	}

	@PostMapping("/edit/{contactId}")
	public ContactForm editForm(@PathVariable Integer contactId) {

		ContactForm form = service.editContact(contactId);

		return form;

	}

	@DeleteMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId) {
		List<ContactForm> list = service.deleteContact(contactId);

		return list;
	}

}
