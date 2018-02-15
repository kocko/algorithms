package codeforces.contests901_1000.problemset932;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RecursiveQueries implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int q = in.ni();
        int[] x = new int[1000001];
        for (int i = 1; i <= 1000000; i++) {
            x[i] = g(i);
        }
        int[][] result = new int[10][1000001];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 1000000; j++) {
                result[i][j] = result[i][j - 1];
                if (x[j] == i) {
                    result[i][j]++;
                }
            }
        }
        while (q-- > 0) {
            int l = in.ni(), r = in.ni(), k = in.ni();
            out.println(result[k][r] - result[k][l - 1]);
        }
    }
    
    private int g(int n) {
        return (n < 10) ? n : g(f(n));
    }
    
    private int f(int n) {
        int result = 1;
        while (n > 0) {
            int d = n % 10;
            if (d != 0) {
                result *= d;
            }
            n /= 10;
        }
        return result;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (RecursiveQueries instance = new RecursiveQueries()) {
            instance.solve();
        }
    }
}
