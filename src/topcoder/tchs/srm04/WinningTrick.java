package topcoder.tchs.srm04;

public class WinningTrick {

    public double minimumSpeed(int[] speed, int yourSpeed) {
        int max = 0;
        for (int i = 0; i < speed.length; i++) {
            if (speed[i] > max) {
                max = speed[i];
            }
        }
        double result = 0d;
        if (yourSpeed < max) {
            result = (max - yourSpeed) / 2.;
        }
        return result;
    }

}
