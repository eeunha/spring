package com.test.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

//종단점(EndPoint)
//- 네트워크상에서 상대방을 인식하기 위한 주소
@ServerEndpoint("/testserver.do")
public class SocketServer {

	// 클라이언트가 연결 요청을 했을 때 발생
	@OnOpen
	public void handleOpen() {
		System.out.println("클라이언트가 접속했습니다.");
	}

	// 클라이언트와 연결이 종료되었을 때 발생
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트가 종료했습니다.");
	}

	// 클라이언트가 서버에게 메시지를 전송했을 때 발생 > ws.send('')
//	@OnMessage
//	public void handleMessage(String msg) {
//		System.out.println("클라이언트가 보낸 메시지: " + msg);
//	}

	@OnMessage
	public String handleMessage(String msg) {
		System.out.println("클라이언트가 보낸 메시지: " + msg);

		return "(응답)" + msg; // 방금 클라이언트에게 돌려주는 메시지
	}

	@OnError
	public void handleError(Throwable e) {
		System.out.println("에러 발생 "+ e.getMessage());
	}
}
