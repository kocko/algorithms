package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HorribleQueries implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class SegmentTree {
        private long[] lo, hi, sum, delta;

        private SegmentTree(int n) {
            lo = new long[4 * n + 1];
            hi = new long[4 * n + 1];
            sum = new long[4 * n + 1];
            delta = new long[4 * n + 1];
            init(1, 0, n - 1);
        }
        
        private void init(int idx, int left, int right) {
            lo[idx] = left;
            hi[idx] = right;
            if (left == right) return;
            int mid = (left + right) / 2;
            init(2 * idx, left, mid);
            init(2 * idx + 1, mid + 1, right);
        }

        private void increment(int left, int right, long value) {
            increment(1, left, right, value);
        }
        
        private void increment(int idx, int left, int right, long value) {
            if (left > hi[idx] || right < lo[idx]) return;
            if (left <= lo[idx] && hi[idx] <= right) {
                delta[idx] += value;
                return;
            }
            propagate(idx);
            increment(idx << 1, left, right, value);
            increment(idx << 1 | 1, left, right, value);
            update(idx);
        }
        
        public long query(int left, int right) {
            return query(1, left, right);
        }
        
        private long query(int idx, int left, int right) {
            if (left > hi[idx] || right < lo[idx]) return 0;
            if (left <= lo[idx] && hi[idx] <= right) return sum[idx] + delta[idx] * range(idx);
            propagate(idx);
            long leftSum = query(idx << 1, left, right);
            long rightSum = query(idx << 1 | 1, left, right);
            update(idx);
            return leftSum + rightSum;
        }
        
        private void propagate(int idx) {
            delta[idx << 1] += delta[idx];
            delta[idx << 1 | 1] += delta[idx];
            delta[idx] = 0;
        }
        
        private void update(int idx) {
            long left = sum[2 * idx] + (delta[2 * idx] * range(2 * idx));
            long right = sum[2 * idx + 1] + (delta[2 * idx + 1] * range(2 * idx + 1));
            sum[idx] = left + right;
        }
      
        private long range(int idx) {
            return hi[idx] - lo[idx] + 1;
        }

    }

    public void solve() {
        int testCases = in.ni();
        while (testCases-- > 0) {
            int n = in.ni(), c = in.ni();
            SegmentTree tree = new SegmentTree(n);
            while (c-- > 0) {
                int type = in.ni(), left = in.ni() - 1, right = in.ni() - 1;
                if (type == 0) {
                    tree.increment(left, right, in.nl());
                } else {
                    out.println(tree.query(left, right));
                }
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
        try (HorribleQueries instance = new HorribleQueries()) {
            instance.solve();
        }
    }
}
