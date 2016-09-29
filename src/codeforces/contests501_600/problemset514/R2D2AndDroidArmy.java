package codeforces.contests501_600.problemset514;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class R2D2AndDroidArmy implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private int n;
    private long[][] tree;
    
    private void build() {
        int m = tree[0].length;
        for (int i = n - 1; i >= 1; i--) {
            long[] value = new long[m];
            long[] x = tree[i << 1];
            long[] y = tree[i << 1 | 1];
            for (int j = 0; j < m; j++) {
                value[j] = Math.max(x[j], y[j]);
            }
            tree[i] = value;
        }
    }
    
    private long[] query(int l, int r) {
        int m = tree[0].length;
        long[] result = new long[m];
        for (l += n, r += n; l < r; r >>= 1, l >>= 1) {
            if ((l & 1) == 1) {
                long[] node = tree[l++];
                for (int i = 0; i < m; i++) {
                    result[i] = Math.max(result[i], node[i]);
                }
            }
            if ((r & 1) == 1) {
                long[] node = tree[--r];
                for (int i = 0; i < m; i++) {
                    result[i] = Math.max(result[i], node[i]);
                }
            }
            
        }
        return result;
    }
    
    public void solve() {
        this.n = in.ni();
        int m = in.ni(), k = in.ni();
        tree = new long[2 * n][m];
        for (int i = 0; i < n; i++) {
            long[] next = new long[m];
            for (int j = 0; j < m; j++) {
                next[j] = in.nl();
            }
            tree[n + i] = next;
        }
        build();
        int left = 0, right = 1;
        int max = 0;
        long[] result = new long[m];
        while (left < n && right <= n) {
            if (left == right) {
                right++;
            }
            long[] temp = query(left, right);
            long sum = Arrays.stream(temp).sum();
            if (sum <= k) {
                if (right - left > max) {
                    max = right - left;
                    result = temp;
                }
                right++;
            } else {
                left++;
            }
        }
        for (long i : result) {
            out.print(i + " ");
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
        try (R2D2AndDroidArmy instance = new R2D2AndDroidArmy()) {
            instance.solve();
        }
    }
}
