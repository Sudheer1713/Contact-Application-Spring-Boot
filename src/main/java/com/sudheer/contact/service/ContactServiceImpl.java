/**
 * 
 */
package com.sudheer.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.contact.bindings.ContactForm;
import com.sudheer.contact.entities.Contact;
import com.sudheer.contact.repository.ContactRepository;

/**
 * @author Sudheer
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm form) {

		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);
		entity.setActiveSw("Y");
		contactRepo.save(entity);

		if (entity.getContactId() != null) {
			return "SUCCESS";
		}

		return "FAILURE";
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<ContactForm> listOfcontacts = new ArrayList<>();
		List<Contact> contact = contactRepo.findAll();
		for (Contact entity : contact) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			listOfcontacts.add(form);

		}

		return listOfcontacts;
	}

	@Override
	public ContactForm editContact(Integer conatctId) {

		Optional<Contact> contact = contactRepo.findById(conatctId);

		if (contact.isPresent()) {
			Contact contactEntity = contact.get();
			contactRepo.save(contactEntity);
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(contactEntity, form);
			return form;
		}
		return null;

	}

	@Override
	public List<ContactForm> deleteContact(Integer conatctId) {

		contactRepo.deleteById(conatctId);

		// view all contacts
		List<ContactForm> dataList = new ArrayList<>();
		List<Contact> contact = contactRepo.findAll();

		/** using java 8 lambdas **/
		contact.stream().forEach(r -> {

			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(r, form);
			dataList.add(form);
		});

		/** using foreach **/
//		for (Contact contactEntity : contact) {
//			ContactForm form = new ContactForm();
//			BeanUtils.copyProperties(contactEntity, form);
//			dataList.add(form);
//		}

		return dataList;
	}

}
