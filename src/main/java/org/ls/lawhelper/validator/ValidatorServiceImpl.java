package org.ls.lawhelper.validator;

import org.ls.lawhelper.data.models.MessageModel;
import org.ls.lawhelper.data.models.TopicModel;
import org.ls.lawhelper.validator.validators.EmptyValidator;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class ValidatorServiceImpl implements ValidatorService {

    @Override
    public void validateTopic(TopicModel topic) {
        EmptyValidator.isValid(topic.getName(), "Name");
    }

    @Override
    public void validateMessage(MessageModel message) {
        EmptyValidator.isValid(message.getMessage(), "Message");
    }
    
}
