package codeforces.contests901_1000.problemset946;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class WeirdSubtractionProcess implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long a = in.nl(), b = in.nl();
        while (a > 0 && b > 0) {
            if (a >= 2 * b) {
                long subtract = b;
                while (a >= 2L * subtract) {
                    subtract *= 2L;
                }
                a -= subtract;
            } else if (b >= 2L * a) {
                long subtract = a;
                while (b >= 2L * subtract) {
                    subtract *= 2L;
                }
                b -= subtract;
            } else {
                break;
            }
        }
        out.println(a + " " + b);
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
        try (WeirdSubtractionProcess instance = new WeirdSubtractionProcess()) {
            instance.solve();
        }
    }
}
