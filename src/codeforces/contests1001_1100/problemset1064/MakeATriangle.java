package codeforces.contests1001_1100.problemset1064;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class MakeATriangle implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b =in.ni(), c = in.ni(), min = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                for (int k = 1; k <= 100; k++) {
                    if (i + j > k && i + k > j && j + k > i) {
                        int cost = abs(i - a) + abs(j - b) + abs(k - c);
                        min = Math.min(cost, min);
                    }
                }
            }
        }
        out.println(min);
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
        try (MakeATriangle instance = new MakeATriangle()) {
            instance.solve();
        }
    }
}
