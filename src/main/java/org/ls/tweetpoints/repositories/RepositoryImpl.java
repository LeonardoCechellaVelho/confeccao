package org.ls.tweetpoints.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ls.tweetpoints.config.AppException;
import org.ls.tweetpoints.config.SurrealConfig;
import org.ls.tweetpoints.data.entities.Topic;
import org.ls.tweetpoints.data.enums.Errors;
import org.ls.tweetpoints.data.enums.HttpErrors;
import org.ls.tweetpoints.data.models.TopicModel;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class RepositoryImpl implements Repository {

    private SurrealConfig driver;

    @Override
    public Topic persistTopic(Topic topic) {
        if (this.findTopic(topic.getName()).isEmpty()) {
            return driver.database().create("topic", topic);
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.MESSAGE_ALREADY_REGISTERED);
        }
    }
    
    @Override
    public Topic getTopic(TopicModel topicModel) {
        List<Topic> topic = this.findTopic(topicModel.getName());
        if (!topic.isEmpty()) {
            return topic.get(0);
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.TOPIC_NOT_FOUND);
        }
    }

    private List<Topic> findTopic(String topicName) {
        Map<String, String> params = new HashMap<>();
        params.put("name", topicName);
        return driver.database().query("SELECT * FROM topic WHERE name = $name", params, Topic.class).get(0).getResult();
    }

}
