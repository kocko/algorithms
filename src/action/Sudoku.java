package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Sudoku implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        boolean[][] row = new boolean[9][10], col = new boolean[9][10], square = new boolean[9][10];
        int[][] grid = new int[9][9];
        int zeroes = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = in.ni();
                if (grid[i][j] != 0) {
                    row[i][grid[i][j]] = true;
                    col[j][grid[i][j]] = true;
                    int squareIdx = (i / 3) * 3 + (j / 3);    
                    square[squareIdx][grid[i][j]] = true;
                } else {
                    zeroes++;
                }
            }
        }
        out: 
        while (zeroes > 0) {
            for (int i = 0; i < 9; i++) {
                int count = 0, number = -1;
                for (int j = 1; j <= 9; j++) {
                    if (!row[i][j]) {
                        count++;
                        number = j;
                    }
                }
                if (count == 1) {
                    for (int j = 0; j < 9; j++) {
                        if (grid[i][j] == 0) {
                            grid[i][j] = number;
                            col[j][number] = true;
                            int squareIdx = (i / 3) * 3 + (j / 3);
                            square[squareIdx][number] = true;
                            zeroes--;
                            continue out;
                        }
                    }
                }
            }
            for (int i = 0; i < 9; i++) {
                int count = 0, number = -1;
                for (int j = 1; j <= 9; j++) {
                    if (!col[i][j]) {
                        count++;
                        number = j;
                    }
                }
                if (count == 1) {
                    for (int j = 0; j < 9; j++) {
                        if (grid[j][i] == 0) {
                            grid[j][i] = number;
                            row[j][number] = true;
                            int squareIdx = (j / 3) * 3 + (i / 3);
                            square[squareIdx][number] = true;
                            zeroes--;
                            continue out;
                        }
                    }
                }
            }
            for (int i = 0; i < 9; i++) {
                int count = 0, number = -1;
                for (int j = 1; j <= 9; j++) {
                    if (!square[i][j]) {
                        count++;
                        number = j;
                    }
                }
                if (count == 1) {
                    for (int j = 0; j < 9; j++) {
                        for (int k = 0; k < 9; k++) {
                            int idx = (j / 3) * 3 + (k / 3);
                            if (idx == i && grid[j][k] == 0) {
                                grid[j][k] = number;
                                row[j][number] = true;
                                col[k][number] = true;
                                square[idx][number] = true;
                                zeroes--;
                                continue out;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                out.print(grid[i][j]);
                out.print(' ');
            }
            out.println();
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
        try (Sudoku instance = new Sudoku()) {
            instance.solve();
        }
    }
}
