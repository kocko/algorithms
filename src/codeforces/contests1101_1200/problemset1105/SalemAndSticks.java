package codeforces.contests1101_1200.problemset1105;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SalemAndSticks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        int bestT = -1, minCost = Integer.MAX_VALUE;
        for (int t = 1; t <= 1000; t++) {
            int cost = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] >= t + 1) {
                    cost += a[i] - t - 1;
                } else if (a[i] <= t - 1) {
                    cost += t - 1 - a[i];
                }
            }
            if (cost < minCost) {
                minCost = cost;
                bestT = t;
            }
        }
        out.println(bestT + " " + minCost);
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
        try (SalemAndSticks instance = new SalemAndSticks()) {
            instance.solve();
        }
    }
}
