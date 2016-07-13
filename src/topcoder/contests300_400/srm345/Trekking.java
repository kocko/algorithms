package topcoder.contests300_400.srm345;

public class Trekking {

    public int findCamps(String trail, String[] plans) {
        int result = Integer.MAX_VALUE;
        boolean found = false;
        for (String p : plans) {
            if (isValid(trail, p)) {
                found = true;
                result = Math.min(result, score(p));
            }
        }
        return found ? result : -1;
    }

    private boolean isValid(String trail, String p) {
        for (int i = 0; i < trail.length(); i++) {
            if (trail.charAt(i) == '^' && p.charAt(i) == 'C') return false;
        }
        return true;
    }

    private int score(String p) {
        int result = 0;
        for (char c : p.toCharArray()) {
            result += (c == 'C' ? 1 : 0);
        }
        return result;
    }

}
