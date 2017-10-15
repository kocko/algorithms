package codeforces.contests801_900.problemset872;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SearchForPrettyIntegers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        boolean[] first = new boolean[10], second = new boolean[10];
        for (int i = 0; i < n; i++) first[in.ni()] = true;
        for (int i = 0; i < m; i++) second[in.ni()] = true;
        int a = 10, b = 10;
        for (int i = 1; i <= 9; i++) {
            if (first[i] && second[i]) {
                out.println(i);
                return;
            } else {
                if (first[i]) a = Math.min(i, a);
                if (second[i]) b = Math.min(i, b);
            }
        }
        out.print(Math.min(a, b));
        out.print(Math.max(a, b));
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
        try (SearchForPrettyIntegers instance = new SearchForPrettyIntegers()) {
            instance.solve();
        }
    }
}
