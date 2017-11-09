package codeforces.contests301_400.problemset340;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximalAreaQuadrilateral implements Closeable {

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
        int n = in.ni();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) points[i] = new Point(in.ni(), in.ni());
        double result = 0d;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double left = 0, right = 0;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    double area = area(points[i], points[j], points[k]);
                    left = Math.min(left, area);
                    right = Math.max(right, area);
                }
                if (right > 0 && left < 0) {
                    result = Math.max(result, right - left);
                }
            }
        }
        out.println(result);
    }
    
    private double area(Point a, Point b, Point c) {
        return ((a.x - c.x) * (b.y - a.y) - (a.x - b.x) * (c.y - a.y)) * 0.5;
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
        try (MaximalAreaQuadrilateral instance = new MaximalAreaQuadrilateral()) {
            instance.solve();
        }
    }
}
