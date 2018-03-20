package topcoder.tchs.srm29;

public class ReverseSums {

    public int getSum(int n) {
        StringBuilder reverse = new StringBuilder(String.valueOf(n)).reverse();
        int m = Integer.valueOf(reverse.toString());
        return n + m;
    }

}
