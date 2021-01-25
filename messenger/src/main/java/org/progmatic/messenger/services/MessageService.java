package org.progmatic.messenger.services;

import org.progmatic.messenger.model.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MessageService {

    private final List<Message> messageList = new ArrayList<>();
    private String senderName = "";

    public List<Message> getMessageList() {
        return messageList;
    }

    public Message searchMessage(int index){
        return messageList.get(index);
    }

    public void addMessage(Message message) {
        messageList.add(message);
    }

    public void deleteMessage(Message message) {
        message.setDeleted();
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}
