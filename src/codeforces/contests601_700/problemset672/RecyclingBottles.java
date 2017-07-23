package codeforces.contests601_700.problemset672;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RecyclingBottles implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long ax = in.nl(), ay = in.nl(), bx = in.nl(), by = in.nl(), tx = in.nl(), ty = in.nl();
        int n = in.ni();
        final double inf = 1e18 + 5;
        double[] dist = new double[n], dist_a = new double[n], dist_b = new double[n];
        double all = 0d;
        for (int i = 0; i < n; i++) {
            int x = in.ni(), y = in.ni();
            dist[i] = dist(tx, ty, x, y);
            dist_a[i] = dist(ax, ay, x, y);
            dist_b[i] = dist(bx, by, x, y);
            all += dist[i];
        }
        all *= 2;
        double alice = inf, bob = inf;
        for (int i = 0; i < n; i++) {
            alice = Math.min(alice, all + dist_a[i] - dist[i]);
            bob = Math.min(bob, all + dist_b[i] - dist[i]);
        }
        double result = Math.min(alice, bob);
        Pair[] p = new Pair[n], q = new Pair[n];
        for (int i = 0; i < n; i++) {
            p[i] = new Pair(i, dist_a[i] - dist[i]);
            q[i] = new Pair(i, dist_b[i] - dist[i]);
        }
        Arrays.sort(p);
        Arrays.sort(q);
        if (n > 1) {
            double min;
            if (p[0].idx == q[0].idx) {
                min = Math.min(p[1].dist + q[0].dist, p[0].dist + q[1].dist);
            } else {
                min = p[0].dist + q[0].dist;
            }
            double both = all + min;
            result = Math.min(result, both);
        }
        out.println(result);
    }
    
    private class Pair implements Comparable<Pair> {
        private int idx;
        private double dist;
        
        private Pair(int idx, double dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(dist, o.dist);
        }
    }
    
    private double dist(long ax, long ay, long bx, long by) {
        return Math.sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by));
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
        try (RecyclingBottles instance = new RecyclingBottles()) {
            instance.solve();
        }
    }
}
