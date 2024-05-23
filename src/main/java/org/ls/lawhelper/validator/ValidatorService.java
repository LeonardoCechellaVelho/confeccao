package org.ls.lawhelper.validator;

import org.ls.lawhelper.data.models.MessageModel;
import org.ls.lawhelper.data.models.TopicModel;

public interface ValidatorService {
    void validateTopic(TopicModel topic);
    void validateMessage(MessageModel message);
}
