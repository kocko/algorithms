package codeforces.contests201_300.problemset287;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IQTest implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[][] grid = new char[4][4];
        for (int i = 0; i < 4; i++) {
            grid[i] = in.next().toCharArray();
        }
        boolean ok = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] ^= 13;
                ok |= check(grid);
                grid[i][j] ^= 13;
            }
        }
        out.println(ok ? "YES" : "NO");
    }
    
    private boolean check(char[][] x) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (x[i][j] == x[i + 1][j] && x[i][j] == x[i][j + 1] && x[i][j] == x[i + 1][j + 1]) return true;
            }
        }
        return false;
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
        try (IQTest instance = new IQTest()) {
            instance.solve();
        }
    }
}
