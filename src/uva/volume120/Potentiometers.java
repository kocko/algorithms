package uva.volume120;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Potentiometers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class FenwickTree {
        private int[] tree;
        private int MAX;
        
        private FenwickTree(int[] arr) {
            int n = arr.length;
            MAX = n;
            tree = new int[MAX + 1];
            for (int i = 0; i < n; i++) {
                update(i + 1, arr[i]);
            }
        }
        
        private void update(int idx, int delta) {
            for (; idx <= MAX; idx += (idx & -idx)) {
                tree[idx] += delta;
            }
        }
        
        private int query(int left, int right) {
            return query(right) - query(left - 1);
        }
        
        private int query(int idx) {
            int result = 0;
            for (; idx > 0; idx -= (idx & -idx)) {
                result += tree[idx];
            }
            return result;
        }
    }

    public void solve() {
        for (int testCase = 1; testCase <= 3; testCase++) {
            int n = in.ni();
            if (n == 0) break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.ni();
            }
            FenwickTree tree = new FenwickTree(arr);
            if (testCase > 1) out.println();
            out.printf("Case %d:\n", testCase);
            while (true) {
                String command = in.next();
                if ("END".equals(command)) break;
                int a = in.ni(), b = in.ni();
                if ("S".equals(command)) {
                    tree.update(a, b - arr[a - 1]);
                    arr[a - 1] = b;
                } else {
                    out.println(tree.query(a, b));
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
        try (Potentiometers instance = new Potentiometers()) {
            instance.solve();
        }
    }
}
