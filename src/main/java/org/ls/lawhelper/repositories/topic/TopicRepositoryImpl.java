package org.ls.lawhelper.repositories.topic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ls.lawhelper.config.AppException;
import org.ls.lawhelper.config.SurrealConfig;
import org.ls.lawhelper.data.entities.Topic;
import org.ls.lawhelper.data.enums.Errors;
import org.ls.lawhelper.data.enums.HttpErrors;
import org.ls.lawhelper.data.models.TopicModel;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class TopicRepositoryImpl implements TopicRepository {

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
