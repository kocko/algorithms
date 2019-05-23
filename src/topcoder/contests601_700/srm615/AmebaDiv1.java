package topcoder.contests601_700.srm615;

import java.util.HashSet;
import java.util.Set;

public class AmebaDiv1 {
  
  public int count(int[] x) {
    int n = x.length;
    Set<Integer> unreachable = new HashSet<>();
    Set<Integer> reachable = new HashSet<>();
    for (int start = 0; start < n; start++) {
      int size = x[start];
      for (int j = 0; j < n; j++) {
        if (x[j] == size) {
          if (!reachable.contains(size)) {
            unreachable.add(size);
          }
          size *= 2;
        }
      }
      reachable.add(size);
      unreachable.remove(size);
    }
    return unreachable.size();
  }
  
}
