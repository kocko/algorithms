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
        int n = in.ni();
        boolean[] have = new boolean[1000001];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            have[x[i]] = true;
            if (i == 0) {
                for (int j = 2 * x[i]; j < have.length; j += x[i]) {
                    have[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int gcd = x[i];
            for (int j = i + 1; j < n; j++) {
                gcd = gcd(gcd, x[j]);
                if (!have[gcd]) {
                    out.println(-1);
                    return;
                }
            }
        }
        out.println(n);
        for (int i = 0; i < n; i++) {
            out.print(x[i]);
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
