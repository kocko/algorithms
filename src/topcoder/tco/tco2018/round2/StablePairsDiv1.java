package topcoder.tco.tco2018.round2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StablePairsDiv1 {

    public int[] findMaxStablePairs(int n, int c, int k) {
        if (n == 1) return new int[0];
        List<Integer> result = new ArrayList<>();

        int x = n, y = n - 1;
        for (int i = 0; i < k; i++) {
            result.add(x);
            result.add(y);
            int sum = x + y - c;
            if (sum % 2 == 1) {
                x = sum / 2;
                y = sum / 2 + 1;
            } else {
                x = sum / 2 - 1;
                y = sum / 2 + 1;
            }
        }
        result.sort(Comparator.naturalOrder());
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
            if (ans[i] < 1 || ans[i] > n) return new int[0];
            if (i > 0) {
                if (ans[i] == ans[i - 1]) return new int[0];
            }
        }
        return ans;
    }
    
}
