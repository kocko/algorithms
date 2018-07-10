package topcoder.tchs.srm06;

import static java.lang.Integer.parseInt;

public class DigitalDisplay {

    public int waysToInterpret(String display) {
        String[] split = display.split(":");
        int a = parseInt(split[0]), b = parseInt(split[1]), c = parseInt(split[2]);
        int result = 0;
        if (check(a, b, c)) result++;
        if (check(a, c, b)) result++;
        if (check(b, a, c)) result++;
        if (check(b, c, a)) result++;
        if (check(c, a, b)) result++;
        if (check(c, b, a)) result++;
        return result;
    }

    private boolean check(int hour, int minute, int second) {
        return hour >= 1 && hour <= 12 && minute >= 0 && minute <= 59 && second >= 0 && second <= 59;
    }

}
