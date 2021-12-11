/**
 * 
 */
package com.sudheer.contact.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Sudheer
 *
 */
@Entity //java class as a entity class, map to db
@Table(name = "CONTACT_DTLS") // its is optional, classs name as a table name
@Data //lombok annotation,generate getters,setters
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {

	@Id // primary key
	@GeneratedValue // generate the value for primary key
	@Column(name = "CONTACT_ID") //this is also optional
	private Integer contactId;

	@Column(name = "CONTACT_NAME")
	private String contactName;

	@Column(name = "CONTACT_EMAIL")
	private String conatctEmail;

	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	
	@Column(name = "CREATED_DATE")
	@CreationTimestamp //todays date,, record created date
	private LocalDate createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp //record updated date
	private LocalDate updatedDate;

}
