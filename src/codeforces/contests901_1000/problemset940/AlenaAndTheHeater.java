package codeforces.contests901_1000.problemset940;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class AlenaAndTheHeater implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        char[] b = in.next().toCharArray();
        int oo = (int) 1e9;
        int l = -oo, r = oo;
        for (int i = 4; i < n; i++) {
            if (b[i] == '1') {
                if (b[i - 1] == '0' && b[i - 2] == '0' && b[i - 3] == '0' && b[i - 4] == '0') {
                    int max = max(a[i], max(max(a[i - 1], a[i - 2]), max(a[i - 3], a[i - 4]))) + 1;
                    l = max(l, max);
                }
            } else {
                if (b[i - 1] == '1' && b[i - 2] == '1' && b[i - 3] == '1' && b[i - 4] == '1') {
                    int min = min(a[i], min(min(a[i - 1], a[i - 2]), min(a[i - 3], a[i - 4]))) - 1;
                    r = min(r, min);
                }
            }
        }
        out.println(l + " " + r);
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
        try (AlenaAndTheHeater instance = new AlenaAndTheHeater()) {
            instance.solve();
        }
    }
}
