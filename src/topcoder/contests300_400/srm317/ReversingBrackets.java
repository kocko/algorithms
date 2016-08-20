package topcoder.contests300_400.srm317;

public class ReversingBrackets {
	
	public String removeBrackets(String s) {
		if (!s.contains("[")) {
			return s;
		}
		String a = s.substring(0, s.indexOf('['));
		String b = new StringBuilder(s.substring(s.indexOf('[') + 1, s.indexOf(']'))).reverse().toString();
		String c = s.substring(s.indexOf(']') + 1);
		return a + b + c;
	}
}
