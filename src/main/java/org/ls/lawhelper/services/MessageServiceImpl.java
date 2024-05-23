package org.ls.lawhelper.services;

import org.ls.lawhelper.data.entities.Message;
import org.ls.lawhelper.data.models.MessageModel;
import org.ls.lawhelper.validator.ValidatorService;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class MessageServiceImpl implements MessageService {

    private ValidatorService validator;

    @Override
    public Message addMessage(MessageModel request) {
        validator.validateMessage(request);
        return Message.from(request);
    }
}
