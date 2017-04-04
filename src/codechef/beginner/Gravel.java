package codechef.beginner;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gravel implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class FenwickTree {
        private long[] tree;
        private int MAX;
        private long[] arr;
        
        private FenwickTree(long[] arr) {
            this.arr = arr;
            this.MAX = arr.length;
            this.tree = new long[MAX + 1]; 
        }
        
        private void update(int left, int right, long value) {
            update(left, value);
            update(right + 1, -value);
        }
        
        private void update(int idx, long value) {
            for (; idx <= MAX; idx += (idx & -idx)) {
                tree[idx] += value;
            }
        }
        
        private long query(int idx) {
            long result = arr[idx - 1];
            for (; idx > 0; idx -= (idx & -idx)) {
                result += tree[idx];
            }
            return result;
        }
    }

    public void solve() {
        int n = in.ni(), q = in.ni(), c = in.ni();
        long[] arr = new long[n];
        Arrays.fill(arr, c);
        FenwickTree tree = new FenwickTree(arr);
        while (q-- > 0) {
            char operation = in.next().charAt(0);
            if (operation == 'S') {
                int left = in.ni(), right = in.ni();
                long value = in.nl();
                tree.update(left, right, value);
            } else {
                int idx = in.ni();
                out.println(tree.query(idx));
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
        try (Gravel instance = new Gravel()) {
            instance.solve();
        }
    }
}
