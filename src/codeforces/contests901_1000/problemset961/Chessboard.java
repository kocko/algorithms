package codeforces.contests901_1000.problemset961;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.lang.Math.sqrt;

public class Chessboard implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        board = new char[2 * n][2 * n];
        pieces = new char[4][n][n];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                char[] line = in.next().toCharArray();
                System.arraycopy(line, 0, pieces[i][j], 0, n);
            }
        }
        for (int i = 0; i < 4; i++) {
            recurse(0);
        }
        out.println(min);
    }

    private int n;
    private int min = (int) 1e8;
    private char[][] board;
    private char[][][] pieces;
    private boolean[] used = new boolean[4];
    
    private void recurse(int count) {
        if (count == 4) {
            check(0);
            check(1);
        } else {
            for (int i = 0; i < 4; i++) {
                if (!used[i]) {
                    used[i] = true;
                    copy(pieces[i], count + 1);
                    recurse(count + 1);
                    used[i] = false;
                }
            }
        }
    }
    
    private void copy(char[][] piece, int place) {
        int x = 0, y = 0;
        switch (place) {
            case 0: { x = 0; y = 0; break; }
            case 1: { x = 0; y = n; break; }
            case 2: { x = n; y = 0; break; }
            case 3: { x = n; y = n; break; }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(piece[i], 0, board[x + i], y, n);
        }
    }
    
    private void check(int even) {
        int odd = even ^ 1, result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int value = (board[i][j] - '0');
                if ((i + j) % 2 == 0) {
                    if (value != even) {
                        result++;
                    }
                } else {
                    if (value != odd) {
                        result++;
                    }
                }
            }
        }
        min = Math.min(result, min);
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
        try (Chessboard instance = new Chessboard()) {
            instance.solve();
        }
    }
}
