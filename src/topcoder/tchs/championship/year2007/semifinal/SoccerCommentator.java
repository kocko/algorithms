package topcoder.tchs.championship.year2007.semifinal;

import static java.lang.Integer.parseInt;

public class SoccerCommentator {

    public int goalsToWin(String score1, String score2, int firstGameHost) {
        String[] a = score1.split(":"), b = score2.split(":");

        int first = parseInt(a[0]) + parseInt(b[0]), second = parseInt(a[1]) + parseInt(b[1]);
        int result = 0, firstAwayGoals, secondAwayGoals;
        if (firstGameHost == 1) {
            firstAwayGoals = parseInt(b[0]);
            secondAwayGoals = parseInt(a[1]);
            if (first == second) {
                if (firstAwayGoals <= secondAwayGoals) {
                    result = 1;
                }
            } else if (first < second) {
                int need = second - first;
                if (firstAwayGoals + need <= secondAwayGoals) {
                    need++;
                }
                result = need;
            }
        } else {
            firstAwayGoals = parseInt(a[0]);
            secondAwayGoals = parseInt(b[1]);

            if (first == second) {
                if (firstAwayGoals <= secondAwayGoals) {
                    result = 1;
                }
            } else if (first < second) {
                int need = second - first;
                if (firstAwayGoals <= secondAwayGoals) {
                    need++;
                }
                result = need;
            }
        }

        return result;
    }

}
