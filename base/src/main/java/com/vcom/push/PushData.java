package com.vcom.push;

import java.io.Serializable;

/**
 * Created by bin on 18/4/18.
 */

public class PushData<T> extends BasePushData implements Serializable {
    private T message_info;

    public T getMessage_info() {
        return message_info;
    }

    public void setMessage_info(T message_info) {
        this.message_info = message_info;
    }
}
