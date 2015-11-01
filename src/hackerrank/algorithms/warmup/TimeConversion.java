package hackerrank.algorithms.warmup;

import java.util.Scanner;

public class TimeConversion {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		String time = input.substring(0, 8);
		String meridiem = input.substring(8);
		System.out.println(convertTo24HourFormat(time, meridiem));
	}
	
	static String convertTo24HourFormat(String time, String meridiem) {
		String[] split = time.split(":");
		int hour = Integer.parseInt(split[0]) % 12;
		if ("PM".equals(meridiem)) {
			hour += 12;
		}
		return (hour < 10 ? "0" + hour : hour) + ":" + split[1] + ":" + split[2];
	}
	
}
