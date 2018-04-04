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

public class MaximumSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Node {
        private int lo, hi, first, second;

        private void assign(int value) {
            first = value;
            second = -1;
        }

        private void merge(Node left, Node right) {
            first = max(left.first, right.first);
            second = min(max(left.first, right.second), max(left.second, right.first));
        }

        public int getValue() {
            return first + second;
        }
    }

    private class SegmentTree {
        private Node[] nodes;
        private int[] x;

        public SegmentTree(int[] x) {
            this.x = x;
            int n = x.length;
            nodes = new Node[getSize(n)];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node();
            }
            init(1, 0, n - 1);
        }

        private int getSize(int n) {
            int size = 1;
            for (; size < n; size <<= 1);
            return size << 1;
        }

        private void init(int idx, int a, int b) {
            nodes[idx].lo = a;
            nodes[idx].hi = b;
            if (a == b) {
                nodes[idx].assign(x[a]);
                return;
            }
            int mid = (a + b) / 2, left = idx << 1, right = left | 1;
            init(left, a, mid);
            init(right, mid + 1, b);
            nodes[idx].merge(nodes[left], nodes[right]);
        }

        public void update(int index, int value) {
            update(1, index, value);
        }

        private void update(int idx, int index, int value) {
            if (nodes[idx].lo == nodes[idx].hi) {
                nodes[idx].assign(value);
                return;
            }
            int mid = (nodes[idx].lo + nodes[idx].hi) / 2;
            if (index <= mid) {
                update(2 * idx, index, value);
            } else {
                update(2 * idx + 1, index, value);
            }
            nodes[idx].merge(nodes[2 * idx], nodes[2 * idx + 1]);
        }

        public int query(int a, int b) {
            return query(1, a, b).getValue();
        }

        private Node query(int idx, int a, int b) {
            if (a == nodes[idx].lo && b == nodes[idx].hi) {
                return nodes[idx];
            }
            int mid = (nodes[idx].lo + nodes[idx].hi) / 2;
            if (b <= mid) {
                return query(2 * idx, a, b);
            }
            if (a > mid) {
                return query(2 * idx + 1, a, b);
            }
            Node result = new Node();
            result.merge(query(2 * idx, a, mid), query(2 * idx + 1, mid + 1, b));
            return result;
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
        while (q-- > 0) {
            char type = in.next().charAt(0);
            if (type == 'U') {
                int idx = in.ni() - 1, delta = in.ni();
                tree.update(idx, delta);
            } else {
                int left = in.ni() - 1, right = in.ni() - 1;
                out.println(tree.query(left, right));
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
        try (MaximumSum instance = new MaximumSum()) {
            instance.solve();
        }
    }
}
