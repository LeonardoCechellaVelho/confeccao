package org.ls.lawhelper.rest.message;

import org.ls.lawhelper.data.entities.Message;
import org.ls.lawhelper.data.models.MessageModel;
import org.ls.lawhelper.services.MessageService;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Path("/message")
public class MessageRestImpl implements MessageRest {
    
    MessageService service;

    @Override
    @Transactional
    public MessageResponse addMessage(MessageModel request) {
        Message message = service.addMessage(request);
        return MessageResponse.builder().message(message).build();
    }

}
