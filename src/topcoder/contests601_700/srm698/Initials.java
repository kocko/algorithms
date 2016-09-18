package topcoder.contests601_700.srm698;

public class Initials {
	
	public String getInitials(String name) {
		String result = "";
		String[] split = name.split("\\s+");
		for (String s : split) {
			result += s.charAt(0);
		}
		return result;
	}
	
}
