package org.koushik.javabrains.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.service.MessageService;

@Path("/messages")
public class MessageResouce {
	MessageService ms = new MessageService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getIt() {
        return ms.getAllMessages();
    }
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam ("messageId") long messageId) {
    	//System.out.println(messageId);
        return ms.getMessage(messageId);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message) {   	
        return ms.addMessage(message);
    }
    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(Message message,@PathParam ("messageId") long messageId) {
    	message.setId(messageId);
        return ms.updateMessage(message);
    }
    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMessage(@PathParam ("messageId") long id) {
         ms.removeMessage(id);
    }
}
