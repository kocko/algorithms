package topcoder.tchs.srm03;

public class BestDecomposition {

    public int maxProduct(int n) {
        int result = 1;
        while (n > 4) {
            result *= 3;
            result %= 10007;
            n -= 3;
        }
        result *= n;
        result %= 10007;
        return result;
    }
}
