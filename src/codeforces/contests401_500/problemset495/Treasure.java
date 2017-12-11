package codeforces.contests401_500.problemset495;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Treasure implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        int[] a = new int[n];
        int[] result = new int[n];
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (x[i] == '(') {
                if (i > 0) a[i] = a[i - 1] + 1;
                else a[i] = 1;
            } else if (x[i] == ')') {
                if (i > 0) a[i] = a[i - 1] - 1;
                else a[i] = -1;
            } else {
                last = i;
                result[i] = 1;
                if (i > 0) a[i] = a[i - 1] - 1;
                else a[i] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                out.println(-1);
                return;
            }
        }
        int k = a[n - 1];
        result[last] += k;
        for (int i = last; i < n; i++) {
            a[i] -= k;
        }
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                out.println(-1);
                return;
            }
        }
        if (a[n - 1] != 0) {
            out.println(-1);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (x[i] == '#') out.println(result[i]);
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
        try (Treasure instance = new Treasure()) {
            instance.solve();
        }
    }
}
