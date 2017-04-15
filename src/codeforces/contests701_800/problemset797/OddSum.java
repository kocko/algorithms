package codeforces.contests701_800.problemset797;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OddSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        int positive = 0;
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            if (x[i] > 0) {
                positive += x[i];
            }
        }
        if (positive % 2 == 1) {
            out.println(positive);
        } else {
            final int INF = (int) 1e9;
            int result = -INF - 1;
            for (int i = 0; i < n; i++) {
                if ((positive - x[i]) % 2 == 1) {
                    result = Math.max(result, positive - Math.abs(x[i]));
                }
            }
            out.println(result);
        }
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
        try (OddSum instance = new OddSum()) {
            instance.solve();
        }
    }
}
