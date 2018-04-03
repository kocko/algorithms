package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Math.sqrt;

public class CanYouAnswerTheseQueries4 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class SegmentTree {
        private long[] x;
        private int[] lo, hi;
        private long[] sum;

        SegmentTree(long[] x) {
            this.x = x;
            int n = x.length;
            lo = new int[4 * n + 1];
            hi = new int[4 * n + 1];
            sum = new long[4 * n + 1];
            init(1, 0, n - 1);
        }

        private void init(int idx, int a, int b) {
            lo[idx] = a;
            hi[idx] = b;
            if (a == b) {
                sum[idx] = x[a];
                return;
            }
            int mid = (a + b) / 2, left = idx << 1, right = left + 1;
            init(left, a, mid);
            init(right, mid + 1, b);
            update(idx);
        }

        public void update(int a, int b) {
            update(1, a, b);
        }

        private void update(int idx, int a, int b) {
            if (a == lo[idx] && b == hi[idx]) {
                propagate(idx);
                return;
            }
            int mid = (lo[idx] + hi[idx]) / 2;
            if (b <= mid) {
                update(2 * idx, a, mid);
            } else if (a > mid) {
                update(2 * idx + 1, mid + 1, b);
            } else {
                update(2 * idx, a, mid);
                update(2 * idx + 1, mid + 1, b);
            }
            update(idx);
        }

        public long query(int a, int b) {
            return query(1, a, b);
        }

        private long query(int idx, int a, int b) {
            if (a <= lo[idx] && hi[idx] <= b) {
                return sum[idx];
            }
            int mid = (lo[idx] + hi[idx]) / 2, left = 2 * idx, right = left + 1;
            if (b <= mid) {
                return query(left, a, mid);
            } else if (a > mid) {
                return query(right, mid + 1, b);
            } else {
                return query(left, a, mid) + query(right, mid + 1, b);
            }
        }

        private void propagate(int idx) {
            if (sum[idx] == hi[idx] - lo[idx] + 1) {
                return;
            }
            if (lo[idx] == hi[idx]) {
                sum[idx] = (long) sqrt(sum[idx]);
                return;
            }
            int left = 2 * idx, right = left + 1;
            propagate(left);
            propagate(right);
            update(idx);
        }

        private void update(int idx) {
            sum[idx] = sum[2 * idx] + sum[2 * idx + 1];
        }
    }

    public void solve() {
        int n = in.ni();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nl();
        }
        int q = in.ni();
        SegmentTree tree = new SegmentTree(x);
        while (q-- > 0) {
            int type = in.ni(), left = in.ni() - 1, right = in.ni() - 1;
            if (type == 0) {
                tree.update(min(left, right), max(left, right));
            } else {
                out.println(tree.query(min(left, right), max(left, right)));
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
        try (CanYouAnswerTheseQueries4 instance = new CanYouAnswerTheseQueries4()) {
            instance.solve();
        }
    }
}
