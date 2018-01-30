package codeforces.contests801_900.problemset892;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class Gluttony implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
            b[i] = a[i];
        }
        sort(b);
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result.put(b[i], b[(i + 1) % n]);
        }
        for (int i = 0; i < n; i++) {
            out.print(result.get(a[i]));
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
        try (Gluttony instance = new Gluttony()) {
            instance.solve();
        }
    }
}
