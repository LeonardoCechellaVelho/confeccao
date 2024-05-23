package org.ls.tweetpoints.services;

import org.ls.tweetpoints.data.entities.Topic;
import org.ls.tweetpoints.data.models.TopicModel;

public interface TopicService {
    Topic addTopic(TopicModel request);
    Topic getTopic(TopicModel request);
}
