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

		List<ContactForm> dataList = new ArrayList<>();

		List<Contact> contacts = contactRepo.findAll();

//		for(Contact contact : contacts)
//		{
//			ContactForm form = new ContactForm();
//			BeanUtils.copyProperties(contact, form);
//			dataList.add(form);
//		}

		/********* OR ************/

		contacts.forEach(c -> {

			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(c, form);
			dataList.add(form);

		});

		return dataList;
	}

	@Override
	public ContactForm editContact(Integer conatctId) {

		Optional<Contact> findAll = contactRepo.findById(conatctId);
		if (findAll.isPresent()) {
			Contact contact = findAll.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(contact, form);
			return form;
		}
		return null;
		
	}

	@Override
	public List<ContactForm> deleteContact(Integer conatctId) {

		contactRepo.deleteById(conatctId);
		return viewContacts();
	}

}
