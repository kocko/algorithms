package codeforces.contests301_400.problemset381;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class SerejaAndBrackets implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Node {
        private int lo, hi, open, close, result;

        private void merge(Node left, Node right) {
            int tmp = min(left.open, right.close);
            result = left.result + right.result + tmp;
            open = left.open + right.open - tmp;
            close = left.close + right.close - tmp;
        }
    }

    private class SegmentTree {
        private char[] x;
        private Node[] nodes;

        private SegmentTree(char[] x) {
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
                if (x[left] == '(') {
                    nodes[idx].open = 1;
                } else {
                    nodes[idx].close = 1;
                }
            } else {
                int mid = (left + right) / 2;
                init(idx << 1, left, mid);
                init(idx << 1 | 1, mid + 1, right);
                nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
            }
        }

        private Node query(int idx, int left, int right) {
            if (nodes[idx].lo > right || nodes[idx].hi < left) return new Node();
            if (nodes[idx].lo >= left && nodes[idx].hi <= right) return nodes[idx];

            Node result = new Node();
            Node l = query(idx << 1, left, right);
            Node r = query(idx << 1 | 1, left, right);
            result.merge(l, r);
            return result;
        }
    }

    public void solve() {
        char[] x = in.next().toCharArray();
        SegmentTree tree = new SegmentTree(x);
        int q = in.ni();
        while (q-- > 0) {
            int left = in.ni() - 1, right = in.ni() - 1;
            out.println(tree.query(1, left, right).result << 1);
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
        try (SerejaAndBrackets instance = new SerejaAndBrackets()) {
            instance.solve();
        }
    }
}
