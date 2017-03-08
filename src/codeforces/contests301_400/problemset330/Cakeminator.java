package codeforces.contests301_400.problemset330;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cakeminator implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int rows = in.ni(), columns = in.ni();
        char[][] grid = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            grid[i] = in.next().toCharArray();
        }
        int result = 0;
        for (int i = 0; i < columns; i++) {
            boolean can = true;
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] == 'S') {
                    can = false;
                    break;
                }
            }
            if (can) {
                result += rows;
                for (int j = 0; j < rows; j++) {
                    grid[j][i] = '*';
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            boolean can = true;
            int count = 0;
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 'S') {
                    can = false;
                    break;
                } else {
                    if (grid[i][j] == '.') count++;
                    grid[i][j] = '*';
                }
            }
            if (can) {
                result += count;
            }
        }
        out.println(result);
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
        try (Cakeminator instance = new Cakeminator()) {
            instance.solve();
        }
    }
}
