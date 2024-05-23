package org.ls.tweetpoints.operations.topic;

import org.ls.tweetpoints.data.entities.Topic;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TopicResponse {

    private Topic topic;
}
