/**
 * 
 */
package com.sudheer.contact.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudheer.contact.entities.Contact;

/**
 * @author Sudheer
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
