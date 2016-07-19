package topcoder.contests601_700.srm694;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinguishableSetDiv2 {
	
	public int count(String[] answer) {
		int result = 0;
        int n = answer.length;
        int m = answer[0].length();
        for (int mask = 0; mask <= (1 << m); mask++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    list.add(i);
                }
            }
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int index : list) {
                    s += answer[i].charAt(index);
                }
                set.add(s);
            }
            if (set.size() == n) {
                result++;
            }
        }
        return result;
	}
    
}
