package topcoder.contests601_700.srm688;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesDiv2Medium  {

    public int[] correct(String s) {
        List<Integer> pool = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char correct = i % 2 == 0 ? '(' : ')';
            if (s.charAt(i) != correct) {
                pool.add(i);
            }
        }

        int[] result = new int[pool.size()]; int next = 0;
        for (Integer i : pool) result[next++] = i;
        return result;
    }

    public static void main(String[] args) {
        int[] result = new ParenthesesDiv2Medium().correct(")(");
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
