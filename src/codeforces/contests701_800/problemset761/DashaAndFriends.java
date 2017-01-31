package codeforces.contests701_800.problemset761;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DashaAndFriends implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), l = in.ni();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.ni();
        for (int i = 0; i < n; i++) b[i] = in.ni();
        int[] p = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                p[0] = a[0] + l - a[n - 1];
                q[0] = b[0] + l - b[n - 1];
            } else {
                p[i] = a[i] - a[i - 1];
                q[i] = b[i] - b[i - 1];
            }
        }
        int[] x = new int[2 * n];
        for (int i = 0; i < n; i++) {
            x[i] = x[n + i] = p[i];
        }
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                ok &= q[j] == x[i + j];
            }
            if (ok) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");
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
        try (DashaAndFriends instance = new DashaAndFriends()) {
            instance.solve();
        }
    }
}
