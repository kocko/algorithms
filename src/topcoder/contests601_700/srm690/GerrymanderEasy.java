package topcoder.contests601_700.srm690;

public class GerrymanderEasy {

    public double getmax(int[] a, int[] b, int k) {
        int n = a.length;
        int[] p = new int[n + 1];
        int[] q = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + a[i];
            q[i + 1] = q[i] + b[i];
        }
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + k; j <= n; j++) {
                int x = p[j] - p[i];
                int y = q[j] - q[i];
                result = Math.max(result, y * 1.0 / x);
            }
        }
        return result;
    }
    
}

