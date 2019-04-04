package topcoder.contests701_800.srm754;

public class SeventhPowers {

  public String reconstructA(int b) {
    StringBuilder result = new StringBuilder();
    int[] powers = new int[10];
    for (int i = 0; i < 10; i++) {
      int p = 1;
      for (int j = 0; j < 7; j++) {
        p *= i;
      }
      powers[i] = p;
    }
    while (b > 0) {
      for (int i = 9; i >= 0; i--) {
        if (powers[i] <= b) {
          b -= powers[i];
          result.append(i);
          break;
        }
      }
    }
    return result.toString();
  }

}
