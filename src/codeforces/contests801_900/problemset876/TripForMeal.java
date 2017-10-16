package codeforces.contests801_900.problemset876;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TripForMeal implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), a = in.ni(), b = in.ni(), c = in.ni(), result = 0;
        char current = 'R';
        while (--n > 0) {
            if (current == 'R') {
                if (a < b) {
                    current = 'O';
                    result += a;
                } else {
                    current = 'Y';
                    result += b;
                }
            } else if (current == 'O') {
                if (a < c) {
                    current = 'R';
                    result += a;
                } else {
                    current = 'Y';
                    result += c;
                }
            } else {
                if (b < c) {
                    current = 'R';
                    result += b;
                } else {
                    current = 'O';
                    result += c;
                }
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
        try (TripForMeal instance = new TripForMeal()) {
            instance.solve();
        }
    }
}
