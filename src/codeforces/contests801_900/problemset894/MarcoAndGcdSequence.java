package codeforces.contests801_900.problemset894;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MarcoAndGcdSequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), gcd = 0;
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            gcd = gcd(gcd, x[i]);
        }
        if (x[0] != gcd) {
            out.println(-1);
            return;
        }
        int[] result = new int[2 * n - 1];
        int idx = 0;
        for (int i = 0; i < result.length; i += 2) {
            result[i] = x[idx++];
            if (i < result.length - 1) {
                result[i + 1] = x[0];
            }
        }
        out.println(2 * n - 1);
        for (int value : result) {
            out.print(value);
            out.print(' ');
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
        try (MarcoAndGcdSequence instance = new MarcoAndGcdSequence()) {
            instance.solve();
        }
    }
}
