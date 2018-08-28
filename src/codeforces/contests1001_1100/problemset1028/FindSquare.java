package codeforces.contests1001_1100.problemset1028;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class FindSquare implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] x = new char[n][m];
        for (int i = 0; i < n; i++) x[i] = in.next().toCharArray();
        for (int i = 0; i < n; i++) {
            int size = 0, start = -1, end = -1;
            for (int j = 0; j < m; j++) {
                if (x[i][j] == 'B') {
                    size++;
                    if (start == -1) {
                        start = j;
                    }
                    end = j;
                }
            }
            if (size != 0) {
                int offset = (end - start) / 2;
                int row = i + offset + 1, col = (start + end) / 2 + 1;
                out.println(row + " " + col);
                break;
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
        try (FindSquare instance = new FindSquare()) {
            instance.solve();
        }
    }
}
