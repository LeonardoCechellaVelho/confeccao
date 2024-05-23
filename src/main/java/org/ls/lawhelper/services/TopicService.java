package org.ls.lawhelper.services;

import org.ls.lawhelper.data.entities.Topic;
import org.ls.lawhelper.data.models.TopicModel;

public interface TopicService {
    Topic addTopic(TopicModel request);
    Topic getTopic(TopicModel request);
}
