package topcoder.tco.tco2018.round2;

import java.util.Stack;

public class LineOff {

    public int movesToDo(String points) {
        char[] x = points.toCharArray();
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : x) {
            if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
                result++;
            } else stack.add(c);
        }
        return result;
    }

}
