package codeforces.contests801_900.problemset814;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AnAbandonedSentimentFromPast implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = in.ni();
        }
        Arrays.sort(b);
        for (int i = k - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (a[j] == 0) {
                    a[j] = b[i];
                    break;
                }
            }
        }
        boolean ok = false;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] >= a[i]) {
                ok = true;
                break;
            }
        }
        out.println(ok ? "Yes" : "No");
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
        try (AnAbandonedSentimentFromPast instance = new AnAbandonedSentimentFromPast()) {
            instance.solve();
        }
    }
}
