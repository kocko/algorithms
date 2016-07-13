package topcoder.contests300_400.srm346;

import java.util.Stack;

public class DiamondHunt {
	
	public int countDiamonds(String mine) {
		Stack<Character> stack = new Stack<>();
		int result = 0;
		for (char c : mine.toCharArray()) {
			if (c == '<') {
				stack.add(c);
			} else {
				if (!stack.isEmpty()) {
					result++;
					stack.pop();
				}
			}
		}
		return result;
	}

}
