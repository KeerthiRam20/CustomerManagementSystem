package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Sevice.IContactService;
import com.example.demo.entity.Contact;

@RestController
@RequestMapping(value="/contact")
@CrossOrigin(origins="http://localhost:3000")
public class ContactController {

	@Autowired
	private IContactService contactService;
	
	@PostMapping(value="/save")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact)
	{
		Contact savedContact=contactService.saveContact(contact);
		String msg="Dear,"+savedContact.getFirstName()+"Thank You for Contacting Us";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
}
