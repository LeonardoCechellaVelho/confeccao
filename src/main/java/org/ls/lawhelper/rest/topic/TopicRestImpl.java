package org.ls.lawhelper.rest.topic;

import org.ls.lawhelper.data.entities.Topic;
import org.ls.lawhelper.data.models.TopicModel;
import org.ls.lawhelper.services.TopicService;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Path("/topic")
public class TopicRestImpl implements TopicRest {
    
    TopicService service;

    @Override
    @Transactional
    public TopicResponse addTopic(TopicModel request) {
        Topic topic = service.addTopic(request);
        return TopicResponse.builder().topic(topic).build();
    }

    @Override
    @Transactional
    public TopicResponse getTopic(String name) {
        Topic topic = service.getTopic(new TopicModel(name));
        return TopicResponse.builder().topic(topic).build();
    }
}
