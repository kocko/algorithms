package codeforces.contests801_900.problemset825;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FiveInARow implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[][] x = new char[10][10];
        for (int i = 0; i < 10; i++) {
            x[i] = in.next().toCharArray();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (x[i][j] == '.') {
                    x[i][j] = 'X';
                    if (ok(x)) {
                        out.println("YES");
                        return;
                    }
                    x[i][j] = '.';
                }
            }
        }
        out.println("NO");
    }
    
    private boolean ok(char[][] x) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (row(x, i, j) || col(x, i, j) || diagonal(x, i, j, 1, 1) || diagonal(x, i, j, 1, -1) || diagonal(x, i, j, -1, 1) || diagonal(x, i, j, -1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean row(char[][] x, int i, int j) {
        for (int k = 0; k < 5; k++) {
            if (i + k == 10) return false;
            if (x[i + k][j] != 'X') return false;
        }
        return true;
    }
    
    private boolean col(char[][] x, int i, int j) {
        for (int k = 0; k < 5; k++) {
            if (j + k == 10) return false;
            if (x[i][j + k] != 'X') return false;
        }
        return true;
    }

    private boolean diagonal(char[][] x, int i, int j, int a, int b) {
        for (int k = 0; k < 5; k++) {
            int p = i + k * a, q = j + k * b;
            if (p < 0 || p >= 10) return false; 
            if (q < 0 || q >= 10) return false; 
            if (x[p][q] != 'X') return false;
        }
        return true;
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
        try (FiveInARow instance = new FiveInARow()) {
            instance.solve();
        }
    }
}
