package com.contact.connector;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.contact.model.GetContactRequest;

public class ContactClient extends WebServiceGatewaySupport{
	
	public Object callSOAPWebService(String url, String request){
		GetContactRequest req = new GetContactRequest();
		req.setUserId(Long.valueOf(request));
		return getWebServiceTemplate().marshalSendAndReceive(url, req);
	}
}