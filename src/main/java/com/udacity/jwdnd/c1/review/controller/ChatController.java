package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.service.AuthenticationService;
import com.udacity.jwdnd.c1.review.service.MessageListingService;
import com.udacity.jwdnd.c1.review.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController{

    private MessageListingService messageListingService;

    public ChatController(MessageListingService messageListingService) {
        this.messageListingService = messageListingService;
    }

    @GetMapping("/chat")
    public String getChat(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        model.addAttribute("sentMessages",this.messageListingService.getChatMessages());
        return "Chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes(){
        return new String[] {"Say", "Shout", "Whisper"};
    }

    @PostMapping("/chat")
    public String addChat(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getPrincipal().toString();
        chatForm.setUsername(user);

        this.messageListingService.addMessage(chatForm);

        chatForm.setMessageText(" ");

        model.addAttribute("sentMessages",this.messageListingService.getChatMessages());

        return "Chat";

    }


}