package codeforces.contests001_100.problemset022;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BargainingTable implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) grid[i] = in.next().toCharArray();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        boolean ones = false;
                        inner:
                        for (int o = i; o <= k; o++) {
                            for (int p = j; p <= l; p++) {
                                if (grid[o][p] == '1') {
                                    ones = true;
                                    break inner;
                                }
                            }
                        }
                        if (!ones) {
                            int size = (k - i + 1 + l - j + 1) * 2;
                            if (size > max) max = size;
                        }
                    }
                }
            }
        }
        out.println(max);
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
        try (BargainingTable instance = new BargainingTable()) {
            instance.solve();
        }
    }
}
