package codeforces.contests901_1000.problemset934;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class ACompatiblePair implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        long[] a = new long[n], b = new long[m];
        for (int i = 0; i < n; i++) a[i] = in.nl();
        for (int i = 0; i < m; i++) b[i] = in.nl();
        int k = -1;
        long max = (long) (- 1e18 - 5);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] * b[j] > max) {
                    max = a[i] * b[j];
                    k = i;
                }
            }
        }
        long ans = (long) (- 1e18 - 5); 
        for (int i = 0; i < n; i++) {
            if (i == k) continue;
            for (int j = 0; j < m; j++) {
                if (a[i] * b[j] > ans) {
                    ans = a[i] * b[j];
                }
            }
        }
        out.println(ans);
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
        try (ACompatiblePair instance = new ACompatiblePair()) {
            instance.solve();
        }
    }
}
