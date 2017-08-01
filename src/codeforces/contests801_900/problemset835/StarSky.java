package codeforces.contests801_900.problemset835;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StarSky implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class FenwickTree {
        private long[][] tree;
        private int MAX;
        
        private FenwickTree(int n) {
            MAX = n + 1;
            tree = new long[MAX + 1][MAX + 1];
        }

        private void update(int x1, int y1, long delta) {
            for (int x = x1; x <= MAX; x += (x & -x))
                for (int y = y1; y <= MAX; y += (y & -y)) {
                    tree[x][y] += delta;
                }
        }

        private int query(int x1, int y1, int x2, int y2) {
            int result = 0;
            for (int x = x2; x > 0; x -= (x & -x)) {
                for (int y = y2; y > 0; y -= (y & -y))
                    result += tree[x][y];
                for (int y = y1 - 1; y > 0; y -= (y & -y))
                    result -= tree[x][y];
            }
            for (int x = x1 - 1; x > 0; x -= (x & -x)) {
                for (int y = y2; y > 0; y -= (y & -y))
                    result -= tree[x][y];
                for (int y = y1 - 1; y > 0; y -= (y & -y))
                    result += tree[x][y];
            }
            return result;
        }
        
    }
    
    public void solve() {
        int n = in.ni(), q = in.ni(), c = in.ni() + 1;
        FenwickTree[] brightness = new FenwickTree[11];
        for (int i = 0; i < 11; i++) {
            brightness[i] = new FenwickTree(100);
        }
        for (int i = 0; i < n; i++) {
            int x = in.ni(), y = in.ni();
            long s = in.nl();
            for (int j = 0; j < 11; j++) {
                brightness[j].update(x, y, (s + j) % c);    
            }
        }
        while (q-- > 0) {
            int t = in.ni() % c;
            int x1 = in.ni(), y1 = in.ni(), x2 = in.ni(), y2 = in.ni();
            out.println(brightness[t].query(x1, y1, x2, y2));
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
        try (StarSky instance = new StarSky()) {
            instance.solve();
        }
    }
}
