package com.dream.springbootframe.demo.websocket;

/**
 * Created by guolele on 2018/4/13.
 */
/*@Controller*/
public class WsController {

   /* @MessageMapping("/welcone")
    @SendTo("/topic/getResponse")*/
    public WiselyResponse say(WiselyMessage message) throws Exception{
        return new WiselyResponse("Welcome, " + message.getName());
    }
}
