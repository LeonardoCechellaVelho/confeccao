package org.ls.lawhelper.services;

import org.ls.lawhelper.data.entities.Topic;
import org.ls.lawhelper.data.models.TopicModel;
import org.ls.lawhelper.repositories.Repository;
import org.ls.lawhelper.validator.ValidatorService;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class TopicServiceImpl implements TopicService {

    private final Repository repository;
    private ValidatorService validator;

    @Override
    public Topic addTopic(TopicModel request) {
        validator.validateTopic(request);
        return this.repository.persistTopic(Topic.from(request));
    }
    
    @Override
    public Topic getTopic(TopicModel request) {
        validator.validateTopic(request);
        return this.repository.getTopic(request);
    }
}
