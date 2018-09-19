package topcoder.contests701_800.srm737;

public class AliceAndBobMedium {

    public int count(int[] a) {
        int n = a.length, result = 0;
        int xor = 0;
        for (int x : a) {
            xor ^= x;
        }
        for (int x : a) {
            int othersXor = xor ^ x;
            if (x > othersXor) {
                result++;
            }
        }
        return result;
    }

}
