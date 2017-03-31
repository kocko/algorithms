package codeforces.contests201_300.problemset295;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GregAndArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class FenwickTree {
        private long[] input;
        private long[] tree;
        private int MAX;
        
        private FenwickTree(long[] input) {
            MAX = input.length;
            this.input = input;
            tree = new long[MAX + 1];
        }
        
        private FenwickTree(int MAX) {
            this.MAX = MAX;
            this.input = new long[MAX];
            this.tree = new long[MAX + 1];
        }
        
        private void update(int idx, long delta) {
            for (; idx <= MAX; idx += (idx & -idx)) {
                tree[idx] += delta;
            }
        }
        
        private void update(int left, int right, long delta) {
            update(left, delta);
            update(right + 1, -delta);
        }
        
        private long query(int idx) {
            long result = input[idx - 1];
            for (; idx > 0; idx -= (idx & -idx)) {
                result += tree[idx];
            }
            return result;
        }
    }
    
    private class Operation {
        private int left, right, delta;
        
        private Operation(int left, int right, int delta) {
            this.left = left;
            this.right = right;
            this.delta = delta;
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni(), k = in.ni();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nl();
        }
        Operation[] operations = new Operation[m + 1];
        for (int i = 1; i <= m; i++) {
            operations[i] = new Operation(in.ni(), in.ni(), in.ni());
        }
        FenwickTree operationsTree = new FenwickTree(m);
        for (int i = 0; i < k; i++) {
            int left = in.ni(), right = in.ni();
            operationsTree.update(left, right, 1);
        }
        FenwickTree tree = new FenwickTree(x);
        for (int i = 1; i <= m; i++) {
            long times = operationsTree.query(i);
            long delta = operations[i].delta * times;
            int left = operations[i].left, right = operations[i].right;
            tree.update(left, right, delta);
        }
        for (int i = 1; i <= n; i++) {
            out.print(tree.query(i));
            out.print(' ');
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
        try (GregAndArray instance = new GregAndArray()) {
            instance.solve();
        }
    }
}
