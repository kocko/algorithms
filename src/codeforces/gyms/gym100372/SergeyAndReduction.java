package codeforces.gyms.gym100372;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SergeyAndReduction implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.ni();
        }
        for (int i = 1; i <= q; i++) {
            int type = in.ni();
            if (type == 0) {
                int left = in.ni(), right = in.ni(), e = in.ni();
                for (int j = left; j <= right; j++) {
                    if (a[j] > 0) {
                        a[j] -= e;
                    }
                }
            } else {
                int left = in.ni(), right = in.ni();
                int count = 0;
                for (int j = left; j <= right; j++) {
                    if (a[j] <= 0) {
                        count++;
                    }
                }
                out.println(count);
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
        try (SergeyAndReduction instance = new SergeyAndReduction()) {
            instance.solve();
        }
    }
}
