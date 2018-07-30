package codeforces.contests1001_1100.problemset1013;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class And implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), x = in.ni();
        int[] a = new int[n];
        boolean[] zero = new boolean[1000001];
        boolean[] one = new boolean[1000001];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
            if (zero[a[i]]) {
                out.println(0);
                return;
            }
            zero[a[i]] = true;
        }
        int result = 3;
        for (int i = 0; i < n; i++) {
            int value = a[i] & x;
            if (value != a[i]) {
                if (zero[value]) {
                    result = Math.min(result, 1);
                }
                if (one[value]) {
                    result = Math.min(result, 2);
                }
                one[value] = true;
            }
        }
        out.println(result == 3 ? -1 : result);
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
        try (And instance = new And()) {
            instance.solve();
        }
    }
}
