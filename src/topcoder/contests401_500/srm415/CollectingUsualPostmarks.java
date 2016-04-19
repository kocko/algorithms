package topcoder.contests401_500.srm415;

import java.util.Arrays;

public class CollectingUsualPostmarks {

    public int numberOfPostmarks(int[] prices, int[] have) {
        int value = 0;
        for (int i : have) {
            value += prices[i];
        }
        Arrays.sort(prices);
        int temp = 0, i;
        for (i = 0; i < prices.length; i++) {
            int next = prices[i];
            if (temp + next > value) break;
            temp += next;
        }
        return i;
    }

}