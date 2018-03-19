package topcoder.contests701_800.srm731;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RingLex {

    public String getmin(String s) {
        int n = s.length();
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        List<String> result = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            for (int prime : primes) {
                if (prime < n) {
                    StringBuilder word = new StringBuilder();
                    int idx = x;
                    for (int i = 0; i < n; i++) {
                        word.append(s.charAt(idx));
                        idx += prime;
                        idx %= n;
                    }
                    result.add(word.toString());
                } else break;
            }
        }
        result.sort(Comparator.naturalOrder());
        return result.get(0);
    }

}
