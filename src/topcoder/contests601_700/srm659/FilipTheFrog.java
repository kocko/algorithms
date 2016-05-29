package topcoder.contests601_700.srm659;

public class FilipTheFrog {

    int l;
    int[] list = new int[1001];
    boolean[] can = new boolean[1001];
    int total;

    public int countReachableIslands(int[] positions, int l) {
        this.l = l;
        for (int i : positions) {
            list[i] = 1;
        }
        start(positions[0]);
        return total;
    }

    private void start(int i) {
        can[i] = true;
        total++;
        for (int j = 1; j <= l; j++) {
            if (i + j <= 1000 && list[i + j] == 1 && !can[i + j]) {
                start(i + j);
            }
            if (i - j >= 0 && list[i - j] == 1 && !can[i - j]) {
                start(i - j);
            }
        }

    }

}