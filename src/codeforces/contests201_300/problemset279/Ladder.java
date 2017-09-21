package codeforces.contests201_300.problemset279;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Ladder implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        int[] right = new int[n], left = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            if (i < n - 1 && x[i + 1] >= x[i]) {
                right[i] += right[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            if (i >= 1 && x[i - 1] >= x[i]) {
                left[i] += left[i - 1];
            }
        }
        while (q-- > 0) {
            int a = in.ni() - 1, b = in.ni() - 1, size = b - a + 1;
            boolean ans = (right[a] >= size || left[b] >= size);
            ans |= right[a] + left[b] >= size;
            out.println(ans ? "Yes" : "No");
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
        try (Ladder instance = new Ladder()) {
            instance.solve();
        }
    }
}
