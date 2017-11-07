package codeforces.contests101_200.problemset190;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Double.max;
import static java.lang.Double.min;
import static java.lang.Math.sqrt;

public class Surrounded implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long[] x = new long[2], y = new long[2], r = new long[2];
        for (int i = 0; i < 2; i++) {
            x[i] = in.nl();
            y[i] = in.nl();
            r[i] = in.nl();
        }
        double dist = sqrt((x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1])), diameter;
        if (dist >= r[0] + r[1]) {
            diameter = dist - r[0] - r[1];
        } else if (((r[0] - r[1]) * (r[0] - r[1])) <= dist * dist && dist * dist <= (r[0] + r[1]) * (r[0] + r[1])) {
            diameter = 0d;
        } else {
            diameter = max(r[0], r[1]) - dist - min(r[0], r[1]);
        }
        out.println(diameter / 2.0);
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
        try (Surrounded instance = new Surrounded()) {
            instance.solve();
        }
    }
}
