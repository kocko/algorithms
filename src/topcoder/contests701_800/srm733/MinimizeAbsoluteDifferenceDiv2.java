package topcoder.contests701_800.srm733;

import static java.lang.Math.abs;

public class MinimizeAbsoluteDifferenceDiv2 {

    public int[] findTriple(int x0, int x1, int x2) {
        double min = Double.MAX_VALUE;
        int[] result = new int[]{0, 1, 2};
        if (value(x0, x1, x2) < min) {
            result = new int[]{0, 1, 2};
            min = value(x0, x1, x2);
        }
        if (value(x0, x2, x1) < min) {
            result = new int[]{0, 2, 1};
            min = value(x0, x2, x1);
        }
        if (value(x1, x0, x2) < min) {
            result = new int[]{1, 0, 2};
            min = value(x1, x0, x2);
        }
        if (value(x1, x2, x0) < min) {
            result = new int[]{1, 2, 0};
            min = value(x1, x2, x0);
        }
        if (value(x2, x0, x1) < min) {
            result = new int[]{2, 0, 1};
            min = value(x2, x0, x1);
        }
        if (value(x2, x1, x0) < min) {
            result = new int[]{2, 1, 0};
        }
        return result;
    }

    private double value(double a, double b, double c) {
        return abs(a / b - c);
    }
    
}
