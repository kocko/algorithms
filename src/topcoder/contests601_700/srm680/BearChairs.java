package topcoder.contests601_700.srm680;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BearChairs {

    public int[] findPositions(int[] atLeast, int d) {
        int n = atLeast.length;
        int[] result = new int[n];
        List<Integer> taken = new ArrayList<Integer>();
        taken.add(2 * 1000 * 1000 * 1000);
        for (int i = 0; i < n; i++) {
            int where = 0;
            if (atLeast[i] <= taken.get(0) - d) {
                where = atLeast[i];
            } else {
                for (int j = 0; ; j++) {
                    where = Math.max(atLeast[i], d + taken.get(j));
                    if (where <= taken.get(j + 1) - d) {
                        break;
                    }
                }
            }
            result[i] = where;
            taken.add(where);
            Collections.sort(taken);
        }
        return result;
    }

}
