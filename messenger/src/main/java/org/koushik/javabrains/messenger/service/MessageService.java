package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messenger.database.Database;
import org.koushik.javabrains.messenger.model.Message;

public class MessageService {
	private Map<Long,Message> messages = Database.getMessages();
	
	public MessageService(){
		messages.put(1L,new Message(1,"Hi1","Deepa1"));
		//messages.put(2L, new Message(2,"Hi2","Deepa2"));
	}
	public List<Message> getAllMessages(){
		
		return new ArrayList<>(messages.values());
	}
 public Message getMessage(long id){
	 return messages.get(id);
 }
 public Message addMessage(Message message){
	 message.setId(messages.size()+1);
	 messages.put(message.getId(), message);
	 return message;
 }
 public Message updateMessage(Message message){
	
	 messages.put(message.getId(), message);
	 return message;
 }
 public Message removeMessage(long id){
	 return messages.remove(id);
 }
}
