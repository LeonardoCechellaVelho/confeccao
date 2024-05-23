package org.ls.tweetpoints.repositories;


import org.ls.tweetpoints.data.entities.Topic;
import org.ls.tweetpoints.data.models.TopicModel;

public interface Repository {

    Topic persistTopic(Topic user);

    Topic getTopic(TopicModel userModel);
}
