package codeforces.contests801_900.problemset849;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class TellYourWorld implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        p = new Point[n + 1];
        for (int i = 1; i <= n; i++) p[i] = new Point(i, in.nl());
        boolean ok = attempt(1, 2); 
        ok |= attempt(2, 3);
        ok |= attempt(1, 3);
        out.println(ok ? "Yes" : "No");
    }
    
    private class Point {
        private long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private int n;
    private Point[] p; 
    
    private boolean attempt(int first, int second) {
        final double eps = 1e-8;
        double a = ((double) (p[first].y - p[second].y)) / (p[first].x - p[second].x);
        double b = p[first].y - a * p[first].x;
        boolean[] ok = new boolean[n + 1];
        ok[first] = ok[second] = true;
        int idx = 0;
        int[] next = new int[2];
        for (int i = 1; i <= n; i++) {
            if (i == first || i == second) continue;
            if (!ok[i]) {
                ok[i] = abs(a * p[i].x + b - p[i].y) < eps;
            }
            if (!ok[i] && idx < 2) {
                next[idx++] = i;
            }
        }
        if (idx == 0) return false;
        if (idx == 1) return true;
        first = next[0];
        second = next[1];
        double a1 = ((double) (p[first].y - p[second].y)) / (p[first].x - p[second].x);
        double b1 = p[first].y - a1 * p[first].x;
        ok[first] = ok[second] = true;
        for (int i = 1; i <= n; i++) {
            if (i == first || i == second) continue;
            if (!ok[i]) {
                ok[i] = abs(a1 * p[i].x + b1 - p[i].y) < eps;
            }
            if (!ok[i]) return false;
        }
        return a == a1 && b != b1;
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
        try (TellYourWorld instance = new TellYourWorld()) {
            instance.solve();
        }
    }
}
