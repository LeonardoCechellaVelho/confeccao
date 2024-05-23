package org.ls.tweetpoints.operations.topic;

import org.ls.tweetpoints.data.entities.Topic;
import org.ls.tweetpoints.data.models.TopicModel;
import org.ls.tweetpoints.services.TopicService;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Path("/user")
public class TopicRestImpl implements TopicRest {
    
    TopicService userService;

    @Override
    @Transactional
    public TopicResponse addTopic(TopicModel request) {
        Topic topic = userService.addTopic(request);
        return TopicResponse.builder().topic(topic).build();
    }

    @Override
    @Transactional
    public TopicResponse getTopic(String name) {
        Topic topic = userService.getTopic(new TopicModel(name));
        return TopicResponse.builder().topic(topic).build();
    }
}
