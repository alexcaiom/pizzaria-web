package br.com.waiso.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
	
	private static DateUtils instance = new DateUtils();
	public static final String BRAZILIAN_PATTERN = "dd/MM/yyyy";
	public static final SimpleDateFormat completeTimer = new SimpleDateFormat("ss.SSSSSSZ");
	
	private DateUtils(){}
	public static DateUtils getInstance(){
		return instance;
	}
	
	public Calendar getCalendar() {
		Calendar c = Calendar.getInstance(LocaleUtils.DEFAULT_LOCALE);
		return c;
	}

	public Integer calendarToInteger(Calendar data) {
		if (data != null){
			return Integer.valueOf(data.get(Calendar.YEAR)
					+ ""
					+ StringUtils.leftPad("" + (data.get(Calendar.MONTH) + 1), "0",
							2)
					+ ""
					+ StringUtils.leftPad("" + data.get(Calendar.DAY_OF_MONTH),
							"0", 2));
		}
		return null;
	}
}
