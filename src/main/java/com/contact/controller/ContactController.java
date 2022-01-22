package com.contact.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.model.GetContactResponse;
import com.contact.service.ContactService;


@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	private ContactService contactService;
	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping("/userid/{id}")
	public ResponseEntity<GetContactResponse> getContactByUserId(@PathVariable("id") String userId) {

		System.out.println("Data Invocation in Progress");
		Optional<String> userIdOptional = Optional.of(userId);
		Optional<GetContactResponse> response= Optional.empty();

		if(userIdOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		response= contactService.getContactByUserIdService(userIdOptional.get());
		
		if(!response.isPresent()) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


		}
		return ResponseEntity.ok(response.get());
	}
	
	@GetMapping("/data")
	public ResponseEntity<String> getData() {
		
		return ResponseEntity.ok("Data");
	}
}
