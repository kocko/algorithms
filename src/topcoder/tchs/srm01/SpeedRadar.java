package topcoder.tchs.srm01;

public class SpeedRadar {

    public double averageSpeed(int minLimit, int maxLimit, int[] readings) {
        int out = 0, n = readings.length, total = 0;
        for (int reading : readings) {
            if (reading >= minLimit && reading <= maxLimit) {
                total += reading;
            } else {
                out++;
            }
        }
        double rem = n - out;
        double result = total / rem;
        if (n < 10 * out) {
            result = 0d;
        }
        return result;
    }

}
