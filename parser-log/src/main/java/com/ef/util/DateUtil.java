package com.ef.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static final String TIME_STAMP_PATTERN = "yyyy-MM-dd.HH:mm:ss";

	public static LocalDateTime formatDate(String date, String pattern) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDateTime.from(dateTimeFormatter.parse(date));
	}
}
