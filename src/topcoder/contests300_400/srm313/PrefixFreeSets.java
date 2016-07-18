package topcoder.contests300_400.srm313;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PrefixFreeSets {
	
	public int maxElements(String[] words) {
        Set<String> set = new HashSet<String>();
        Collections.addAll(set, words);
        int count = 0;
        for (String s : set) {
            boolean ok = true;
            for (String t : set) {
                if (!t.equals(s) && t.startsWith(s)) {
                    ok = false;
                    break;
                }
            }
            if (ok) count++;
        }
		return count; 
	}
}
