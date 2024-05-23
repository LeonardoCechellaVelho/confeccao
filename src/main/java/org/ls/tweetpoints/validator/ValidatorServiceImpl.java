package org.ls.tweetpoints.validator;

import org.ls.tweetpoints.data.models.TopicModel;
import org.ls.tweetpoints.validator.validators.EmptyValidator;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class ValidatorServiceImpl implements ValidatorService {

    @Override
    public void validateTopic(TopicModel topic) {
        EmptyValidator.isValid(topic.getName(), "Name");
    }
    
}
