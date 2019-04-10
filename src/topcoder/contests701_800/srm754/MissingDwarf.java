package topcoder.contests701_800.srm754;

public class MissingDwarf {

  public int getHeight(int[] h) {
    int max = 0, sum = 0;
    for (int i : h) {
      max = Math.max(i, max);
      sum += i;
    }
    int result = max + 1;
    int diff = (sum + result) % 7;
    if (diff != 0) {
      result += (7 - diff);
    }
    return result;
  }

}
