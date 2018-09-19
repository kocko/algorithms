package topcoder.contests701_800.srm737;

public class Make737Easy {

    public int count(String s) {
        char[] x = s.toCharArray();
        int n = x.length, result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (x[i] == '7' && x[j] == '3' && x[k] == '7') result++;
                }
            }
        }
        return result;
    }
}
