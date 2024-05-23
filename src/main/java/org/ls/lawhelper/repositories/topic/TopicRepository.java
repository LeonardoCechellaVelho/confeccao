package org.ls.lawhelper.repositories.topic;


import org.ls.lawhelper.data.entities.Topic;
import org.ls.lawhelper.data.models.TopicModel;

public interface TopicRepository {

    Topic persistTopic(Topic user);

    Topic getTopic(TopicModel userModel);
}
