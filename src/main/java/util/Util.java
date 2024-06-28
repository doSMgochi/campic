package util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Util {
	public static String getFirstThreeLines(String text) {
        if (text == null) {
            return "";
        }
        String[] lines = text.split("\r\n|\r|\n");
        StringBuilder result = new StringBuilder();
        int lineCount = Math.min(lines.length, 3);
        for (int i = 0; i < lineCount; i++) {
            result.append(lines[i]);
            if (i < lineCount - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	
    public static String getDaysAgo(String dateString) {
        try {
        	Date date = sdf.parse(dateString);
            long diffInMillies = Math.abs(new Date().getTime() - date.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            return diff + "일 전";
             
        } catch (ParseException e) {
            e.printStackTrace();
            return "날짜 형식 오류";
        }
    }
}
