package topcoder.contests601_700.srm606;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EllysNumberGuessing {

  public int getNumber(int[] guesses, int[] answers) {
    final int MIN = 1, MAX = (int) 1e9;
    Set<Integer> possible = new HashSet<>();
    int n = guesses.length;
    for (int i = 0; i < n; i++) {
      Set<Integer> next = new HashSet<>();
      if (guesses[i] - answers[i] >= MIN) next.add(guesses[i] - answers[i]);
      if (guesses[i] + answers[i] <= MAX) next.add(guesses[i] + answers[i]);
      if (i > 0) {
        Iterator<Integer> iterator = next.iterator();
        while (iterator.hasNext()) {
          int nxt = iterator.next();
          if (!possible.contains(nxt)) {
            iterator.remove();
          }
        }
      }
      possible = next;
    }
    int count = possible.size();
    return count == 1 ? possible.iterator().next() : (count > 1 ? -1 : -2);
  }

}
