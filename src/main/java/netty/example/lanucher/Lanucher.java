package netty.example.lanucher;


import netty.example.server.WebSocketServer;

/**
 *https://blog.csdn.net/a906998248/article/details/52839425
 */
public class Lanucher {

	public static void main(String[] args) throws Exception {
		// 启动WebSocket
		new WebSocketServer().run(WebSocketServer.WEBSOCKET_PORT);
	}
	
}
