package topcoder.contests601_700.srm605;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlienAndHamburgers {

  public int getNumber(int[] type, int[] taste) {
    int n = type.length;
    List<List<Integer>> temp = new ArrayList<>();
    for (int i = 0; i <= 100; i++) {
      temp.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      temp.get(type[i]).add(taste[i]);
    }
    for (int i = 1; i <= 100; i++) {
      temp.get(i).sort(Comparator.reverseOrder());
    }
    int result = 0, different = 0, totalTaste = 0;
    List<List<Integer>> types = new ArrayList<>();
    for (List<Integer> list : temp) if (list.size() > 0) types.add(list);
    types.sort((o1, o2) -> Integer.compare(o2.get(0), o1.get(0)));
    for (List<Integer> hamburgers : types) {
      int current = 0, newResult = result;
      for (Integer hamburger : hamburgers) {
        if ((different + 1) * (totalTaste + current + hamburger) > newResult) {
          newResult = (different + 1) * (totalTaste + current + hamburger);
          current += hamburger;
        } else break;
      }
      if (newResult > result) {
        different++;
        totalTaste += current;
        result = different * totalTaste;
      }
    }
    return result;
  }

}
