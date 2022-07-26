package com.pms.pmsapp.fixture;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pms.pmsapp.common.data.Message;

public class MessageFixture {

	public static List<Message> createTriggerMessageListFixture() {

		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, 1999);
		cal1.set(Calendar.MONTH, Calendar.DECEMBER);
		cal1.set(Calendar.DAY_OF_MONTH, 31);
		Date date1 = cal1.getTime();

		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, 2008);
		cal2.set(Calendar.MONTH, Calendar.NOVEMBER);
		cal2.set(Calendar.DAY_OF_MONTH, 29);
		Date date2 = cal2.getTime();

		List<Message> msgList = new ArrayList<>();
		msgList.add(new Message(1L, "TRIG1", "Notification Alert: Watchlist Stock hits 1st Trigger",
				"Notification Alert: Adobe Inc.[ADBE] hits 1st Trigger at 457.87.", "user1", "N", date1));
		msgList.add(new Message(2L, "TRIG2", "Notification Alert: Watchlist Stock hits 2nd Trigger",
				"Notification Alert: Taiwan Semiconductor Manufacturing Company Limited[TSM] hits 2nd Trigger at 81.95.",
				"user1", "N", date2));
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
