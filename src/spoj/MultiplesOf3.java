package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MultiplesOf3 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Node {
        private int lo, hi, delta;
        private int zero, one, two;

        private void add(int value) {
            delta += value;
            delta %= 3;
        }

        private int getZero() {
            if (delta == 0) return zero;
            else if (delta == 1) return two;
            return one;
        }

        private int getOne() {
            if (delta == 0) return one;
            else if (delta == 1) return zero;
            return two;
        }

        private int getTwo() {
            if (delta == 0) return two;
            else if (delta == 1) return one;
            return zero;
        }

        private void merge(Node left, Node right) {
            zero = left.getZero() + right.getZero();
            one = left.getOne() + right.getOne();
            two = left.getTwo() + right.getTwo();
        }
    }

    private class SegmentTree {
        private Node[] nodes;

        public SegmentTree(int n) {
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
                nodes[idx].zero = 1;
            } else {
                int mid = (left + right) / 2;
                init(idx << 1, left, mid);
                init(idx << 1 | 1, mid + 1, right);
                nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
            }
        }

        public void update(int idx, int left, int right) {
            if (nodes[idx].lo > right || nodes[idx].hi < left) return;
            if (nodes[idx].lo >= left && nodes[idx].hi <= right) {
                nodes[idx].add(1);
                return;
            }
            propagate(idx);
            update(idx << 1, left, right);
            update(idx << 1 | 1, left, right);
            nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
        }

        private void propagate(int idx) {
            nodes[idx << 1].add(nodes[idx].delta);
            nodes[idx << 1 | 1].add(nodes[idx].delta);
            nodes[idx].delta = 0;
        }

        public int query(int idx, int left, int right) {
            if (nodes[idx].lo > right || nodes[idx].hi < left) return 0;
            if (nodes[idx].lo >= left && nodes[idx].hi <= right) {
                return nodes[idx].getZero();
            }
            propagate(idx);
            int l = query(idx << 1, left, right);
            int r = query(idx << 1 | 1, left, right);
            nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
            return l + r;
        }
    }

    public void solve() {
        int n = in.ni(), q = in.ni();
        SegmentTree tree = new SegmentTree(n);
        while (q-- > 0) {
            int type = in.ni(), a = in.ni(), b = in.ni();
            if (type == 0) {
                tree.update(1, a, b);
            } else {
                out.println(tree.query(1, a, b));
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
        try (MultiplesOf3 instance = new MultiplesOf3()) {
            instance.solve();
        }
    }
}
