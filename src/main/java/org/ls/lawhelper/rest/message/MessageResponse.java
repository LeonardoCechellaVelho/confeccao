package org.ls.lawhelper.rest.message;

import org.ls.lawhelper.data.entities.Message;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageResponse {

    private Message message;
}
