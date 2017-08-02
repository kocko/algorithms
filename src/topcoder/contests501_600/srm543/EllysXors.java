package topcoder.contests501_600.srm543;

public class EllysXors {
    
    public long getXor(long a, long b) {
        return xors(b) ^ xors(a - 1);
    }

    private long xors(long x) {
        long result = 0;
        int i = 0;
        while ((1L << i) <= x) {
            if (i == 0) {
                long ones = ((x >> 1) & 1) ^ (x & 1);
                result |= ones;
            } else {
                long period = 1L << (i + 1);
                long bits = x - (1L << i) + 1;

                bits %= period;

                if (bits <= (period >> 1)) {
                    bits &= 1;
                } else {
                    bits = 0;
                }
                if (bits == 1) {
                    result |= (1L << i);
                }
            }
            i++;
        }
        return result;
    }
    
}
