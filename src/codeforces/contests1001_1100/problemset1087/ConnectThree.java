package codeforces.contests1001_1100.problemset1087;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Math.abs;

public class ConnectThree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] a = {in.ni(), in.ni()};
        int[] b = {in.ni(), in.ni()};
        int[] c = {in.ni(), in.ni()};

        int x_min = min(a[0], b[0]), x_max = max(a[0], b[0]);
        int y_min = min(a[1], b[1]), y_max = max(a[1], b[1]);

        int[] closest = a;
        int dist = dist(a[0], a[1], c[0], c[1]);
        for (int x = x_min; x <= x_max; x++) {
            for (int y = y_min; y <= y_max; y++) {
                int d = dist(c[0], c[1], x, y);
                if (d < dist) {
                    closest = new int[]{x, y};
                    dist = d;
                }
            }
        }
        Set<String> result = new HashSet<>();
        path(result, a[0], a[1], closest[0], closest[1]);
        path(result, b[0], b[1], closest[0], closest[1]);
        path(result, c[0], c[1], closest[0], closest[1]);

        out.println(result.size());
        for (String point : result) {
            out.println(point);
        }
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return abs(x1 - x2) + abs(y1 - y2);
    }

    private void path(Set<String> result, int x1, int y1, int x2, int y2) {
        int x_min = min(x1, x2), x_max = max(x1, x2);
        int y_min = min(y1, y2), y_max = max(y1, y2);
        if (x1 == x2) {
            for (int y = y_min; y <= y_max; y++) {
                result.add(x1 + " " + y);
            }
        } else if (y1 == y2) {
            for (int x = x_min; x <= x_max; x++) {
                result.add(x + " " + y1);
            }
        } else {
            int step = x1 < x2 ? 1 : -1;
            int x;
            for (x = x1; x != x2; x += step) {
                result.add(x + " " + y1);
            }
            step = y1 < y2 ? 1 : -1;
            for (int y = y1; y != y2; y += step) {
                result.add(x + " " + y);
            }
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
        try (ConnectThree instance = new ConnectThree()) {
            instance.solve();
        }
    }
}
