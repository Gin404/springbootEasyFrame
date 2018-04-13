package com.dream.springbootframe.demo.websocket;

import lombok.Data;

/**
 * Created by guolele on 2018/4/13.
 */
@Data
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public WiselyResponse() {
    }
}
