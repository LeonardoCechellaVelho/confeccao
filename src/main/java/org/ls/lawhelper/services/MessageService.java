package org.ls.lawhelper.services;

import org.ls.lawhelper.data.entities.Message;
import org.ls.lawhelper.data.models.MessageModel;

public interface MessageService {
    Message addMessage(MessageModel request);
}
