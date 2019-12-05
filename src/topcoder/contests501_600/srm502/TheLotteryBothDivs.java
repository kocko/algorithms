package topcoder.contests501_600.srm502;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TheLotteryBothDivs {

  public double find(String[] goodSuffixes) {
    Set<String> suffixes = new HashSet<String>();
    Collections.addAll(suffixes, goodSuffixes);
    outer:
    while (true) {
      for (String x : suffixes) {
        for (String y : suffixes) {
          if (x.endsWith(y) && !x.equals(y)) {
            suffixes.remove(x);
            continue outer;
          }
        }
      }
      break;
    }
    double[] power = new double[11];
    power[0] = 1d;
    for (int i = 1; i <= 10; i++) {
      power[i] = power[i - 1] / 10;
    }
    double result = 0;
    for (String s : suffixes) {
      result += power[s.length()];
    }
    return result;
  }

}
