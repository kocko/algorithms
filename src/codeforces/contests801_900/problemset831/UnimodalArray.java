package codeforces.contests801_900.problemset831;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UnimodalArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n + 2];
        for (int i = 1; i <= n; i++) x[i] = in.ni();
        int a = 0, b = n + 1;
        for (int i = 1; i <= n; i++) {
            if (x[i] > x[i - 1]) a++;
            else break;
        }
        for (int i = n; i >= 1; i--) {
            if (x[i] > x[i + 1]) b--;
            else break;
        }
        boolean ok = a <= b;
        for (int i = a; i <= b; i++) {
            if (x[i] != x[a]) ok = false;
        }
        out.println(ok ? "YES" : "NO");
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
        try (UnimodalArray instance = new UnimodalArray()) {
            instance.solve();
        }
    }
}
