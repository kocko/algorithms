package uva.volume102;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ModularFibonacci implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next()), m = Integer.parseInt(in.next());
            MOD = 1L << m;
            fibonacciMod(n);
        }
    }

    private long MOD;
    
    private void fibonacciMod(int n) {
        long[][] vector = {{0L, 1L}}, matrix = {{0L, 1L}, {1L, 1L}};
        matrix = multiply(vector, power(matrix, n));
        long result = matrix[0][0] % MOD;
        if (result < 0) result += MOD;
        out.println(result);
    }
    
    private long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    long value = (a[i][k] * b[k][j]) % MOD;
                    result[i][j] = (result[i][j] + value) % MOD;
                }
            }
        }
        return result;
    }
    
    private long[][] power(long[][] m, int p) {
        int n = m.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1L;
        }
        while (p > 0) {
            if (p % 2 == 1) result = multiply(result, m);
            m = multiply(m, m);
            p >>= 1;
        }
        return result;
    }
    

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (ModularFibonacci instance = new ModularFibonacci()) {
            instance.solve();
        }
    }
}
