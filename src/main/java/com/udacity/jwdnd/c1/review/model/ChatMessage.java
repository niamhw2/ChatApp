package com.udacity.jwdnd.c1.review.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ChatMessage {

    private String messageText;
    private String username;
    private Integer messageid;

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}