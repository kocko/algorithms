package topcoder.contests501_600.srm600;

public class ORSolitaire {

  public int getMinimum(int[] numbers, int goal) {
    int result = numbers.length;
    for (int zeroBit = 0; zeroBit < 32; zeroBit++) {
      if ((goal & (1 << zeroBit)) != 0) {
        int cnt = 0;
        for (int x : numbers) {
          if (((x | goal) == goal) && ((x & (1 << zeroBit)) != 0)) {
            cnt++;
          }
        }
        result = Math.min(result, cnt);
      }
    }
    return result;
  }

}
