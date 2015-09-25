package com.test.websocket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;
import org.joda.time.LocalTime;

@ServerEndpoint("/clock")
public class WSocketClock {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	static ScheduledExecutorService timer = Executors
			.newSingleThreadScheduledExecutor();

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@OnOpen
	public void showTime(final Session session) {
		logger.info("Connected... " + session.getId());
		Timer timer1 = new Timer();
		timer1.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {
					logger.info("Session " + session.getId() + ": "
							+ new Date().toString());
					session.getBasicRemote().sendText(
							"WebSocket, Laptop Timer: "
									+ new Date().toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, 3000, 3000);
	}

	@SuppressWarnings("unused")
	private void sendTimeToAll(Session session) {
		try {
			logger.info("Sending time ... " + sdf.format(LocalTime.now()));
			session.getBasicRemote().sendText(
					"Local time: " + sdf.format(LocalTime.now()));
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	@OnMessage
	public String onMessage(String message, Session session) {
		return message;
	}

	@OnClose
	public void onClose() {
		logger.info("Session is closed.");
	}
}
