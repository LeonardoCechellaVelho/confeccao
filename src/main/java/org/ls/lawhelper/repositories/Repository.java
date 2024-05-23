package org.ls.lawhelper.repositories;


import org.ls.lawhelper.data.entities.Topic;
import org.ls.lawhelper.data.models.TopicModel;

public interface Repository {

    Topic persistTopic(Topic user);

    Topic getTopic(TopicModel userModel);
}
