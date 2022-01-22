package com.contact.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.contact.connector.ContactClient;
import com.contact.model.GetContactResponse;



@Service
public class ContactService {
	
	@Value("${contactClientUrl}")
	private String contactClientUrl;
	
	@Autowired
	ContactClient contactClient;
	
	public Optional<GetContactResponse> getContactByUserIdService(String userId) {

		Optional<GetContactResponse> response= Optional.empty();
		response = Optional.of((GetContactResponse)contactClient.callSOAPWebService(contactClientUrl,userId));
		
		return response;


	}
}
