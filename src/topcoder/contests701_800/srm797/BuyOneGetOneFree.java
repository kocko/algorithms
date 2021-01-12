package topcoder.contests701_800.srm797;

import java.util.Arrays;

public class BuyOneGetOneFree {

  public int buy(int[] prices) {
    Arrays.sort(prices);
    int result = 0;
    for (int i = prices.length - 1; i >= 0; i -= 2) {
      result += prices[i];
    }
    return result;
  }

}
