package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageListingService {

    private MessageMapper chatMessageList;
    private static final Logger logger = LoggerFactory.getLogger("MessageListingService");

    public MessageListingService(MessageMapper chatMessageList) {
        this.chatMessageList = chatMessageList;
    }

    public void addMessage(ChatForm chatForm){

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());
        logger.info("MessageType: " + chatForm.getMessageType());
        switch (chatForm.getMessageType()){
            case "Shout":
                String upperCase = chatForm.getMessageText().toUpperCase();
                chatMessage.setMessageText(upperCase);
                break;
            case "Whisper":
                String lowerCase = chatForm.getMessageText().toLowerCase();
                chatMessage.setMessageText(lowerCase);
                break;
            default:
                chatMessage.setMessageText(chatForm.getMessageText());
                break;
        }
        logger.debug("chatForm: " + chatForm.getMessageText());
        logger.debug("chatMessage: "+chatMessage.getMessageText());
        chatMessageList.insertChatMessage(chatMessage);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessageList.getAllChatMessages();
    }




}
