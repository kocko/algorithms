package topcoder.contests401_500.srm499;

public class ColorfulRabbits {

    public int getMinimum(int[] replies) {
        final int MAX = 1000001;
        int[] count = new int[MAX];
        for (int reply : replies) {
            count[reply]++;
        }
        int result = 0;
        for (int i = 0; i < MAX; i++) {
            if (count[i] > 0) {
                int size = (i + 1), groups = (count[i] / size) + (count[i] % size > 0 ? 1 : 0);
                result += groups * size;
            }
        }
        return result;
    }
    
}
