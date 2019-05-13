package topcoder.contests701_800.srm758;

import java.util.Comparator;
import java.util.PriorityQueue;

public class WildSequence {

  public int[] construct(int head, int[] rest) {
    int[] result = increasing(head, rest);
    if (result == null) result = decreasing(head, rest);
    return result;
  }
  
  private int[] increasing(int head, int[] rest) {
    int n = rest.length + 1;
    int[] result = new int[n];
    result[0] = head;
    PriorityQueue<Integer> inc = new PriorityQueue<>();
    PriorityQueue<Integer> dec = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < n - 1; i++) {
      inc.add(rest[i]);
      dec.add(rest[i]);
    }
    for (int i = 1; i < n; i++) {
      if (i % 2 == 1) {
        int next = inc.poll();
        result[i] = next;
        dec.remove(next);
      } else {
        int next = dec.poll();
        result[i] = next;
        inc.remove(next);
      }
    }
    return ok(result) ? result : null;
  }
  
  private int[] decreasing(int head, int[] rest) {
    int n = rest.length + 1;
    int[] result = new int[n];
    result[0] = head;
    PriorityQueue<Integer> inc = new PriorityQueue<>();
    PriorityQueue<Integer> dec = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < n - 1; i++) {
      inc.add(rest[i]);
      dec.add(rest[i]);
    }
    for (int i = 1; i < n; i++) {
      if (i % 2 == 1) {
        int next = dec.poll();
        result[i] = next;
        inc.remove(next);
      } else {
        int next = inc.poll();
        result[i] = next;
        dec.remove(next);
      }
    }
    return ok(result) ? result : null;
  }
  
  private boolean ok(int[] x) {
    if (x.length == 1) return true;
    int[] result = new int[x.length - 1];
    for (int i = 1; i < x.length; i++) {
      if (x[i] > x[i - 1]) {
        result[i - 1] = 1;
      } else if (x[i] < x[i - 1]) {
        result[i - 1] = -1;
      } else return false;
    }
    boolean ok = true;
    for (int i = 1; i < result.length; i++) {
      ok &= result[i] != result[i - 1];
    }
    return ok;
  }
}
