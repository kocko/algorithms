package codeforces.contests301_400.problemset334;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class EightPointSets implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Point {
        private int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve() {
        List<Point> points = new ArrayList<>();
        Set<Integer> x = new TreeSet<>(), y = new TreeSet<>();
        for (int i = 0; i < 8; i++) {
            int _x = in.ni(), _y = in.ni();
            points.add(new Point(_x, _y));
            x.add(_x);
            y.add(_y);
        }
        boolean ok = x.size() == 3 && y.size() == 3;
        int i = 0, j = 0;
        for (Integer _x : x) {
            for (Integer _y : y) {
                if (i == 1 && j == 1) {
                    boolean has = false;
                    for (Point p : points) {
                        if (p.x == _x && p.y == _y) {
                            has = true;
                            break;
                        }
                    }
                    if (has) {
                        ok = false;
                    }
                } else {
                    boolean has = false;
                    for (Point p : points) {
                        if (p.x == _x && p.y == _y) {
                            has = true;
                            break;
                        }
                    }
                    if (!has) {
                        ok = false;
                    }
                }
                j++;
            }
            i++;
            j = 0;
        }
        out.println(ok ? "respectable" : "ugly");
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
        try (EightPointSets instance = new EightPointSets()) {
            instance.solve();
        }
    }
}
