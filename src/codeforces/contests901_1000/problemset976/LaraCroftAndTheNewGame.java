package codeforces.contests901_1000.problemset976;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class LaraCroftAndTheNewGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), m = in.nl();
        long k = in.nl();
        long row = 1, col = 1;
        if (k < n) {
            row += k;
        } else {
            row = n;
            k -= (n - 1);
            long batch = k / (m - 1);
            row -= (batch - 1);
            long offset = k % (m - 1);
            if (offset > 0) {
                col = batch % 2 == 0 ? 1 : m;
                row--;
                if (batch % 2 == 1) {
                    col -= offset - 1;
                } else {
                    col += offset;
                }
            } else {
                col = batch % 2 == 0 ? 2 : m;
            }
        }
        out.println(row + " " + col);
        
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
        try (LaraCroftAndTheNewGame instance = new LaraCroftAndTheNewGame()) {
            instance.solve();
        }
    }
}
