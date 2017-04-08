package topcoder.tco.tco2017.round1;

import java.util.Arrays;

public class CoinConstruction {

    public int[] construct(int k) {
        int[] bag = new int[20];
        int idx = 0;
        int i = 0;
        while ((1 << i) < k) {
            bag[idx++] = (1 << i);
            k -= (1 << i);
            i++;
        }
        if (k > 0) {
            bag[idx++] = k;
        }
        return Arrays.copyOf(bag, idx);
    }

}
