package topcoder.contests701_800.srm730;

public class ExpectedMinimumPowerDiv2 {

    public double findExp(int n, int x) {
        long total = 0, p = 0;
        for (int min = 1; min <= n - x + 1; min++) {
            long sets = comb(n - min, x - 1);
            total += sets;
            long bit = (1L << min);
            p += bit * sets;
        }
        return p / (double) total;
    }

    private long comb(int n, int k) {
        if (k == 0) return 1L;
        return (n * comb(n - 1, k - 1)) / k;
    }
    
}
