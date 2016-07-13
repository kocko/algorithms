package topcoder.contests300_400.srm346;

public class CommonMultiples {

    long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public int countCommMult(int[] a, int lower, int upper) {
        long base = 1;
        for (int i : a) {
            base = lcm(base, i);
        }
        int result = 0;
        long start = base;
        while (start < lower) start += base;
        while (start <= upper) {
            result++;
            start += base;
        }
        return result;
    }
}
