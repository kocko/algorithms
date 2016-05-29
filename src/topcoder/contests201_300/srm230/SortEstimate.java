package topcoder.contests201_300.srm230;

public class SortEstimate {

    public double howMany(int c, int time) {
        double left = 0, right = 4e+9, t1 = 2000000000;
        while (true) {
            double mid = (right + left) / 2;
            double val = calc(mid, c);

            if (Math.abs(val - t1) < 1e-9) {
                return mid;
            }

            t1 = val;
            if (val < time) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }

    private double calc(double n, double c) {
        return n * Math.log(n) * c / Math.log(2);
    }

    public static void main(String[] args) {
        System.out.println(new SortEstimate().howMany(1, 8));
        System.out.println(new SortEstimate().howMany(2, 16));
        System.out.println(new SortEstimate().howMany(37, 12392342));
        System.out.println(new SortEstimate().howMany(1, 2000000000));
    }
}
