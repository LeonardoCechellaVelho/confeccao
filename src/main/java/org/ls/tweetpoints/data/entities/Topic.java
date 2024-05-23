package org.ls.tweetpoints.data.entities;

import org.ls.tweetpoints.data.models.TopicModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
public class Topic {
    private String id;
    private String name;

    public static Topic from(TopicModel userModel) {
        return new Topic(null, userModel.getName());
    }
}
