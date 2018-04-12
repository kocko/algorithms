package topcoder.tchs.srm07;

import java.util.HashSet;
import java.util.Set;

public class StraightArray {

    public int howManyMore(int[] nums) {
        int result = 5;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            int a = 0;
            for (int i = num; i <= num + 4; i++) {
                if (set.contains(i)) a++;
            }
            int b = 0;
            for (int i = num - 4; i <= num; i++) {
                if (set.contains(i)) b++;
            }
            int max = Math.max(a, b);
            result = Math.min(result, 5 - max);
        }
        return result;
    }

}
