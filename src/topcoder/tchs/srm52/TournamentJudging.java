package topcoder.tchs.srm52;

import static java.lang.Math.round;

public class TournamentJudging {

    public int getPoints(int[] rawScores, int[] conversionFactor) {
        int result = 0, n = rawScores.length;
        for (int i = 0; i < n; i++) {
            result += round(((double) rawScores[i]) / conversionFactor[i]);
        }
        return result;
    }
}
