package topcoder.contests601_700.srm688;

public class ParenthesesDiv2Easy {

    public int getDepth(String s) {
        int result = 0;
        int current = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                current++;
            } else if (c == ')') {
                current--;
            }
            result = Math.max(result, current);
        }
        return result;
    }

}
