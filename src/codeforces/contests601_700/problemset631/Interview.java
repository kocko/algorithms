package codeforces.contests601_700.problemset631;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Interview implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < 2 * n; i++) {
            if (i <= n - 1) {
                a[i] = in.ni();
            } else {
                b[i - n] = in.ni();
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long temp = f(a, i, j) + f(b, i, j);
                result = Math.max(result, temp);
            }
        }
        out.println(result);
    }

    private long f(int[] list, int l, int r) {
        long result = 0;
        for (int i = l; i <= r; i++) {
            result |= list[i];
        }
        return result;
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

    public static void main(String[] args) {
        new Interview().solve();
    }
}
