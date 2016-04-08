package topcoder.contests101_200.srm146;

public class Yahtzee {

    public int maxPoints(int[] toss) {
        int[] count = new int[7];
        for (int i : toss) {
            count[i]++;
        }
        int best = 0;
        for (int i = 1; i < 7; i++) {
            best = Math.max(count[i] * i, best);
        }
        return best;
    }

}
