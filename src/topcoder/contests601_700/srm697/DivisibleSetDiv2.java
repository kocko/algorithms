package topcoder.contests601_700.srm697;

public class DivisibleSetDiv2 {

    public String isPossible(int[] b) {
        double sum = 0d;
        for (int i : b) sum += 1.0 / i;
        return sum <= 1.0 + 1e-7 ? "Possible" : "Impossible";
    }

}
