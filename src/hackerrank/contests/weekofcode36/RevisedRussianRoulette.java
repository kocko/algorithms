package hackerrank.contests.weekofcode36;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RevisedRussianRoulette implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), min = 0, max = 0, current = 0;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            if (next == 1) {
                max++;
                current++;
            } else {
                int steps = current / 2 + (current % 2);
                min += steps;
                current = 0;
            }
        }
        int steps = current / 2 + (current % 2);
        min += steps;
        out.printf("%d %d\n", min, max);
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
        try (RevisedRussianRoulette instance = new RevisedRussianRoulette()) {
            instance.solve();
        }
    }
}
