package topcoder.contests401_500.srm415;

public class KnockoutTourney {

    public int meetRival(int n, int you, int rival) {
        int result = 1;
        while (true) {
            you = (you + 1) / 2;
            rival = (rival + 1) / 2;
            if (you == rival) break;
            result++;
        }
        return result;
    }
}
