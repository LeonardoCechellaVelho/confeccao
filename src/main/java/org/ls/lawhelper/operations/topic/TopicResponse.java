package org.ls.lawhelper.operations.topic;

import org.ls.lawhelper.data.entities.Topic;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TopicResponse {

    private Topic topic;
}
