package topcoder.contests300_400.srm370;

public class Containers {

    public int wastedSpace(int[] containers, int[] packages) {
        int result = 0;
        int x = 0;
        for (int p : packages) {
            while (containers[x] < p) {
                x++;
            }
            containers[x] -= p;
        }
        for (int i : containers) {
            result += i;
        }
        return result;
    }

}
