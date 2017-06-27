package codeforces.contests801_900.problemset820;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class MisterBAndAngleInPolygon implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        double n = in.ni(), a = in.ni();
        double angle = (180 * (n - 2)) / n;
        double segments = n - 2;
        double x = angle / segments;
        int result = 3;
        double best = abs(180 / n - a);
        for (int i = 4; i <= n; i++) {
            double temp = abs((i - 2) * x - a);
            if (temp < best) {
                best = temp;
                result = i;
            }
        }
        out.println("2 1 " + result);
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
        try (MisterBAndAngleInPolygon instance = new MisterBAndAngleInPolygon()) {
            instance.solve();
        }
    }
}
