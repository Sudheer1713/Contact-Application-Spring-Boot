/**
 * 
 */
package com.sudheer.contact.bindings;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sudheer
 *
 */

//dto,vo,bo outdated terminology
//back end data in the form of object stored in to entity
//front end data in the form of object stored in to bindings

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactForm {
	

	private Integer contactId;

	private String contactName;

	private String conatctEmail;

	private String contactNumber;

	private String activeSw;

	private LocalDate createdDate;

	private LocalDate updatedDate;

}
