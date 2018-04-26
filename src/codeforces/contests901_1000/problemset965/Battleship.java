package codeforces.contests901_1000.problemset965;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class Battleship implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        k = in.ni();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        score = new int[n][n];
        calculate(grid);
        int max = 0, x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (score[i][j] > max) {
                    max = score[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        out.println((x + 1) + " " + (y + 1));
    }

    private int k;
    private int[][] score;

    private void calculate(char[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int current = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.') {
                    current++;
                    if (current >= k) {
                        for (int l = j - k + 1; l <= j; l++) {
                            score[i][l]++;
                        }
                    }
                } else {
                    current = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int current = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == '.') {
                    current++;
                    if (current >= k) {
                        for (int l = i - k + 1; l <= i; l++) {
                            score[l][j]++;
                        }
                    }
                } else {
                    current = 0;
                }
            }
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
        try (Battleship instance = new Battleship()) {
            instance.solve();
        }
    }
}
