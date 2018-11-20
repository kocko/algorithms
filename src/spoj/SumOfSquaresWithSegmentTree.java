package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SumOfSquaresWithSegmentTree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Node {
        private int lo, hi;
        private long squareSum, linearSum, delta, equalityValue;
        private boolean flag;

        private int getRange() {
            return hi - lo + 1;
        }

        private long getSquareSum() {
            if (flag) {
                return getRange() * equalityValue * equalityValue;
            } else {
                return squareSum + 2 * delta * linearSum + getRange() * delta * delta;
            }
        }

        private long getLinearSum() {
            return flag ? getRange() * equalityValue : linearSum;
        }

        private void merge(Node left, Node right) {
            squareSum = left.getSquareSum() + right.getSquareSum();
            linearSum = left.getLinearSum() + right.getLinearSum();
        }
    }

    private class SegmentTree {
        private long[] x;
        private Node[] nodes;

        private SegmentTree(long[] x) {
            this.x = x;
            int n = x.length;
            nodes = new Node[4 * n + 1];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node();
            }
            init(1, 0, n - 1);
        }

        private void init(int idx, int left, int right) {
            nodes[idx].lo = left;
            nodes[idx].hi = right;
            if (left == right) {
                nodes[idx].linearSum = x[left];
                nodes[idx].squareSum = x[left] * x[left];
            } else {
                int mid = (left + right) / 2;
                init(idx << 1, left, mid);
                init(idx << 1 | 1, mid + 1, right);
                nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
            }
        }

        private void equalize(int idx, int left, int right, long value) {
            if (nodes[idx].lo > right || nodes[idx].hi < left) return;
            if (nodes[idx].lo >= left && nodes[idx].hi <= right) {
                nodes[idx].flag = true;
                nodes[idx].delta = 0;
                nodes[idx].equalityValue = value;
                nodes[idx].linearSum = nodes[idx].getRange() * value;
                nodes[idx].squareSum = nodes[idx].getRange() * value * value;
            } else {
                propagate(idx);
                equalize(idx << 1, left, right, value);
                equalize(idx << 1 | 1, left, right, value);
                nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
            }
        }

        private void increment(int idx, int left, int right, long delta) {
            if (nodes[idx].lo > right || nodes[idx].hi < left) return;
            if (nodes[idx].lo >= left && nodes[idx].hi <= right) {
                nodes[idx].flag = false;
                nodes[idx].equalityValue = 0;
                nodes[idx].delta += delta;
            } else {
                propagate(idx);
                increment(idx << 1, left, right, delta);
                increment(idx << 1 | 1, left, right, delta);
                nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
            }
        }

        private void propagate(int idx) {
            if (nodes[idx].flag) {
                nodes[idx << 1].flag = true;
                nodes[idx << 1].equalityValue = nodes[idx].equalityValue;
                nodes[idx << 1 | 1].flag = true;
                nodes[idx << 1 | 1].equalityValue = nodes[idx].equalityValue;
                nodes[idx].flag = false;
                nodes[idx].equalityValue = 0;
            } else {
                nodes[idx << 1].delta += nodes[idx].delta;
                nodes[idx << 1 | 1].delta += nodes[idx].delta;
                nodes[idx].delta = 0;
            }
        }

        private long query(int idx, int left, int right) {
            if (nodes[idx].lo > right || nodes[idx].hi < left) return 0;
            if (nodes[idx].lo >= left && nodes[idx].hi <= right) {
                return nodes[idx].getSquareSum();
            }
            propagate(idx);
            long l = query(idx << 1, left, right);
            long r = query(idx << 1 | 1, left, right);
            nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
            return l + r;
        }
    }

    public void solve() {
        int t = in.ni();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.ni(), q = in.ni();
            long[] x = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nl();
            }
            SegmentTree tree = new SegmentTree(x);
            out.printf("Case %d:\n", testCase);
            while (q-- > 0) {
                int type = in.ni(), left = in.ni() - 1, right = in.ni() - 1;
                if (type == 0) {
                    tree.equalize(1, left, right, in.nl());
                } else if (type == 1) {
                    tree.increment(1, left, right, in.nl());
                } else {
                    out.println(tree.query(1, left, right));
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
        try (SumOfSquaresWithSegmentTree instance = new SumOfSquaresWithSegmentTree()) {
            instance.solve();
        }
    }
}
