package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);
	
	public List<Contact>  getAllContacts();
	
	public Contact getContactById(Integer contactId);
	
	
	public boolean deleteContactById(Integer contactId);
	
	
}
