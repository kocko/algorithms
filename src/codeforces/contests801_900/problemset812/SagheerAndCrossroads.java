package codeforces.contests801_900.problemset812;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SagheerAndCrossroads implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[][] grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = in.ni();
            }
        }
        boolean accident = false;
        for (int i = 0; i < 4; i++) {
            boolean green = grid[i][3] == 1;
            boolean cars = false;
            for (int j = 0; j < 3; j++) {
                cars |= grid[i][j] == 1; 
            }
            cars |= grid[(i + 1) % 4][0] == 1;
            cars |= grid[(i + 2) % 4][1] == 1;
            cars |= grid[(i + 3) % 4][2] == 1;
            accident |= (green & cars);
        }
        out.println(accident ? "YES" : "NO");
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
        try (SagheerAndCrossroads instance = new SagheerAndCrossroads()) {
            instance.solve();
        }
    }
}
