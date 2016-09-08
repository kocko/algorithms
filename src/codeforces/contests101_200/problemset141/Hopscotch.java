package codeforces.contests101_200.problemset141;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Hopscotch implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(),  x = in.ni(), y = in.ni();
        double half = (double) a / 2;
        if (x >= a || x <= -a) {
            out.println(-1);
        } else {
            if (y % a == 0 && y != 0) {
                out.println(-1);
                return;
            }
            int row = y / a + 1;
            if (row % 2 == 1 && row != 1) {
                if (x == 0) {
                    out.println(-1);
                } else {
                    int result = 3 * (row - 1) / 2;
                    if (x > 0) {
                        result++;
                    }
                    out.println(result);
                }
            } else if (row == 1) {
                if (y == 0 || x >= half || x <= -half) {
                    out.println(-1);
                } else {
                    out.println(1);
                }
            } else {
                if (x >= half || x <= -half) {
                    out.println(-1);
                } else {
                    int k = row / 2;
                    out.println(3 * k - 1);
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
        try (Hopscotch instance = new Hopscotch()) {
            instance.solve();
        }
    }
}
