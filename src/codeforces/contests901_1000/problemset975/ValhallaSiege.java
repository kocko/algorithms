package codeforces.contests901_1000.problemset975;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ValhallaSiege implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        long[] x = new long[n + 1], prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = in.nl();
            prefix[i] = prefix[i - 1] + x[i];
        }
        long add = 0;
        while (q-- > 0) {
            long arrows = in.nl();
            int left = 1, right = n, front = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (prefix[mid] - add >= arrows) {
                    front = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (front == -1 || (front == n && (prefix[front] - add == arrows))) {
                out.println(n);
                add = 0;
            } else {
                out.println(n - front + (prefix[front] - add > arrows ? 1 : 0));
                add += arrows;
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
        try (ValhallaSiege instance = new ValhallaSiege()) {
            instance.solve();
        }
    }
}
