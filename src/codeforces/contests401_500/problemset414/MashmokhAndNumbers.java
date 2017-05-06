package codeforces.contests401_500.problemset414;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MashmokhAndNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] result = new int[n];
        if (n == 1) {
            if (k != 0) {
                out.println(-1);
            } else {
                out.println(1);
            }
            return;
        }
        int pairs = n / 2;
        if (pairs > k) {
            out.println(-1);
            return;
        }
        int x = k - (n - 2) / 2;
        result[0] = x;
        result[1] = 2 * x;
        for (int i = 2; i < n; i++) {
            result[i] = result[1] + i - 1;
        }

        for (int i : result) {
            out.print(i);
            out.print(' ');
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
        try (MashmokhAndNumbers instance = new MashmokhAndNumbers()) {
            instance.solve();
        }
    }
}