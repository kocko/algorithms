package codeforces.contests701_800.problemset755;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PolandBallAndPolygon implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class SegmentTree {
        
        private long[] tree;
        private int n;
        
        private SegmentTree(int n) {
            this.n = n;
            this.tree = new long[n << 1];
        }
        
        private void update(int p) {
            for (tree[p += n] += 1L; p > 1; p >>= 1) {
                tree[p >> 1] = tree[p] + tree[p ^ 1];
            }
        }
        
        private long query(int left, int right) {
            long result = 0L;
            for (left += n, right += n; left < right; left >>= 1, right >>= 1) {
                if ((left & 1) == 1) result += tree[left++];
                if ((right & 1) == 1) result += tree[--right];
            }
            return result;
        }
    }
    
    public void solve() {
        int n = in.ni(), k = in.ni();
        long[] result = new long[n];
        if (k > n / 2) {
            k = n - k;
        }
        int a = 1;
        int b = (a + k) > n ? a + k - n : (a + k);
        result[0] = 2;
        SegmentTree tree = new SegmentTree(n + 1);
        tree.update(a);
        tree.update(b);
        for (int i = 1; i < n; i++) {
            a = b;
            b = (a + k) > n ? a + k - n : (a + k);
            result[i] = result[i - 1] + 1L;
            long d = 0L;
            if (a > b) {
                d += tree.query(a + 1, n + 1);
                d += tree.query(0, b);
            } else {
                d += tree.query(a + 1, b + 1);
            }
            result[i] += d;
            tree.update(a); 
            tree.update(b);
        }
        for (long i : result) {
            out.print(i + " ");
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
        try (PolandBallAndPolygon instance = new PolandBallAndPolygon()) {
            instance.solve();
        }
    }
}
