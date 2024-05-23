package org.ls.lawhelper.data.entities;

import org.ls.lawhelper.data.models.MessageModel;

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
public class Message {
    private String id;
    private String name;

    public static Message from(MessageModel userModel) {
        return new Message(null, userModel.getMessage());
    }
}
