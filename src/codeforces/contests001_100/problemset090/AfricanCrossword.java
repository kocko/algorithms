package codeforces.contests001_100.problemset090;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class AfricanCrossword implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] x = new char[n][m];
        for (int i = 0; i < n; i++) {
            x[i] = in.next().toCharArray();
        }
        int[][] rows = new int[n][26], cols = new int[m][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int c = x[i][j] - 'a';
                rows[i][c]++;
                cols[j][c]++;
            }
        }
        boolean[][] crossed = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int c = x[i][j] - 'a';
                if (rows[i][c] > 1 || cols[j][c] > 1) crossed[i][j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!crossed[i][j]) {
                    out.print(x[i][j]);
                }
            }
        }
        out.println();
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
        try (AfricanCrossword instance = new AfricanCrossword()) {
            instance.solve();
        }
    }
}
