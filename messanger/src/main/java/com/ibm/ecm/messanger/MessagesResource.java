package com.ibm.ecm.messanger;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.ecm.messanger.model.Message;
import com.ibm.ecm.messanger.service.MessageService;


@Path("messages")
public class MessagesResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path ("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long id) {
		
		return messageService.getMessage(id);
	
	}
}
