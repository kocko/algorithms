package codeforces.contests1001_1100.problemset1027;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class NumbersOnTheChessboard implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        while (q-- > 0) {
            out.println(getNumber(n, in.nl(), in.nl()));
        }
    }
    
    private long getNumber(long n, long row, long col) {
        long writtenSoFar;
        if ((row + col) % 2 == 0) {
            if (n % 2 == 0) {
                writtenSoFar = (row - 1) * (n / 2);
            } else {
                long hi = (n + 1) / 2, lo = n / 2;
                if (row % 2 == 0) {
                    writtenSoFar = (row / 2) * hi + (row / 2 - 1) * lo;
                } else {
                    writtenSoFar = (row / 2) * (hi + lo);
                }
            }
            
        } else {
            writtenSoFar = (n * n + 1) / 2;
            if (n % 2 == 0) {
                writtenSoFar += (row - 1) * (n / 2);
            } else {
                long hi = (n + 1) / 2, lo = n / 2;
                if (row % 2 == 0) {
                    writtenSoFar += (row / 2) * hi + (row / 2 - 1) * lo - 1;
                } else {
                    writtenSoFar += (row / 2) * (hi + lo);
                }
            }
        }
        return writtenSoFar + (col + 1) / 2;
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
        try (NumbersOnTheChessboard instance = new NumbersOnTheChessboard()) {
            instance.solve();
        }
    }
}
