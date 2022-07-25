package com.pms.pmsapp.fixture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pms.pmsapp.common.data.Message;

public class MessageFixture {

	public static List<Message> createTriggerMessageListFixture() {

		List<Message> msgList = new ArrayList<>();
		msgList.add(new Message(1L, "TRIG1", "Notification Alert: Watchlist Stock hits 1st Trigger",
				"Notification Alert: Adobe Inc.[ADBE] hits 1st Trigger at 457.87.", "user1", "N", new Date()));
		msgList.add(new Message(2L, "TRIG2", "Notification Alert: Watchlist Stock hits 2nd Trigger",
				"Notification Alert: Taiwan Semiconductor Manufacturing Company Limited[TSM] hits 2nd Trigger at 81.95.",
				"user1", "N", new Date()));
		msgList.add(new Message(3L, "TRIG3", "Notification Alert: Watchlist Stock hits 3rd Trigger",
				"Notification Alert: Taiwan Semiconductor Manufacturing Company Limited[TSM] hits 3rd Trigger at 73.10.",
				"user1", "N", new Date()));
		msgList.add(new Message(4L, "TRIG1", "Notification Alert: Watchlist Stock hits 1st Trigger",
				"Notification Alert: Sea Limited[SE] hits 1st Trigger at 197.76.", "user2", "N", new Date()));
		msgList.add(new Message(5L, "TRIG2", "Notification Alert: Watchlist Stock hits 2nd Trigger",
				"Notification Alert: Sea Limited[SE] hits 2nd Trigger at 154.61.", "user2", "N", new Date()));

		return msgList;
	}

}
