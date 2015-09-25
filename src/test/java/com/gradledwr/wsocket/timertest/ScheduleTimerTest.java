package com.test.wsocket.timertest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ScheduleTimerTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Test
	public void testTimer() {
		ScheduledExecutorService timer = Executors
				.newSingleThreadScheduledExecutor();
		timer.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("Testing..");
			}
		}, 0, 1, TimeUnit.SECONDS);
	}

	@Test
	public void testTimer1() {
		Timer timer1 = new Timer();
		timer1.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				System.out.println(new Date().toString());

			}
		}, 3000, 3000);
	}
	
}
