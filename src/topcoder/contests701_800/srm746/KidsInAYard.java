package topcoder.contests701_800.srm746;

public class KidsInAYard {
    public int howMany(int r2, int r3, int r5) {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == r2 && i % 3 == r3 && i % 5 == r5) {
                return i;
            }
        }
        return 0;
    }
}
