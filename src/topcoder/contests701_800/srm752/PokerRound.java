package topcoder.contests701_800.srm752;

public class PokerRound {

  public int amount(int T) {
    for (int i = 0; i <= 10000; i++) {
      if (T == 10000 - 8 * i) {
        return 10000 - i;
      }
    }
    return -1;
  }

}
