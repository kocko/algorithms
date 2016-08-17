package topcoder.contests300_400.srm316;

import java.util.Scanner;

public class HiddenMessage {
	
	public String getMessage(String text) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(text);
		while (sc.hasNext()) {
			sb.append(sc.next().charAt(0));
		}
		return sb.toString();
	}
	
}
