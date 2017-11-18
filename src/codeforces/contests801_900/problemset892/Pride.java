package codeforces.contests801_900.problemset892;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Pride implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), ones = 0, gcd = 0;
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            gcd = gcd(gcd, x[i]);
            if (x[i] == 1) ones++;
        }
        if (ones > 0) {
            out.println(n - ones);
        } else {
            if (gcd > 1) {
                out.println(-1);
                return;
            }
            int min = 2005;
            for (int i = 0; i < n; i++) {
                int temp = x[i];
                for (int j = i + 1; j < n; j++) {
                    temp = gcd(temp, x[j]);
                    if (temp == 1) {
                        min = Math.min(min, j - i);
                    }
                }
            }
            out.println(n - 1 + min);
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
        try (Pride instance = new Pride()) {
            instance.solve();
        }
    }
}
