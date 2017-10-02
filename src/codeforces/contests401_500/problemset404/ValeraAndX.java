package codeforces.contests401_500.problemset404;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ValeraAndX implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) grid[i] = in.next().toCharArray();
        boolean ok = true;
        char letter = grid[0][0];
        for (int i = 0; i < n; i++) {
            ok &= grid[i][i] == letter;
            ok &= grid[i][n - i - 1] == letter;
        }
        ok &= grid[0][0] != grid[0][1];
        letter = grid[0][1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && i + j != n - 1) {
                    ok &= grid[i][j] == letter;
                }
            }
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
        try (ValeraAndX instance = new ValeraAndX()) {
            instance.solve();
        }
    }
}
