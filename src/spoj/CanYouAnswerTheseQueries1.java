package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class CanYouAnswerTheseQueries1 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class SegmentTree {
        private int[] lo, hi, sum, max, x;
        
        public SegmentTree(int[] x) {
            int n = x.length;
            this.x = x;
            lo = new int[4 * n + 1];
            hi = new int[4 * n + 1];
            sum = new int[4 * n + 1];
            max = new int[4 * n + 1];
            init(1, 0, n - 1);
        }
        
        private int init(int idx, int a, int b) {
            lo[idx] = a;
            hi[idx] = b;
            if (a == b) {
                return (sum[idx] = x[a]);
            }
            int mid = (a + b) / 2;
            int left = init(2 * idx, a, mid), right = init(2 * idx + 1, mid + 1, b);
            max[idx] = Math.max(left, right);
            return sum[idx] = left + right;
        }
        
        private int query(int a, int b) {
            return query(1, a, b);
        }
        
        private int query(int idx, int a, int b) {
            if (a > hi[idx] || b < lo[idx]) return Integer.MIN_VALUE;
            if (a <= lo[idx] && b >= hi[idx]) return max[idx];
            return Math.max(query(2 * idx, a, b), query(2 * idx + 1, a, b));
        }
    }

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        SegmentTree tree = new SegmentTree(x);
        int q = in.ni();
        while(q-- > 0) {
            out.println(tree.query(in.ni() - 1, in.ni() - 1));
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
        try (CanYouAnswerTheseQueries1 instance = new CanYouAnswerTheseQueries1()) {
            instance.solve();
        }
    }
}
