package codeforces.contests1001_1100.problemset1011;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class PlanningTheExpedition implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] have = new int[101];
        for (int i = 0; i < m; i++) {
            have[in.ni()]++;
        }
        int left = 1, right = 101, result = 0;
        while (left <= right) {
            int days = left + (right - left) / 2;
            if (ok(have, days, n)) {
                result = max(result, days);
                left = days + 1;
            } else {
                right = days - 1;
            }
        }
        out.println(result);
    }

    private boolean ok(int[] have, int days, int people) {
        int result = 0;
        for (int type : have) result += (type / days);
        return result >= people;
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
        try (PlanningTheExpedition instance = new PlanningTheExpedition()) {
            instance.solve();
        }
    }
}
