package codeforces.contests301_400.problemset352;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JeffAndDigits implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int five = 0, zero = 0;
        for (int i = 0; i < n; i++) {
            if (in.ni() == 5) {
                five++;
            } else {
                zero++;
            }
        }
        int fives = 9 * (five / 9);
        if (fives == 0) {
            if (zero == 0) {
                out.println(-1);
            } else {
                out.println(0);
            }
        } else {
            if (zero == 0) {
                out.println(-1);
            } else {
                for (int i = 0; i < fives; i++) {
                    out.print(5);
                }
                for (int i = 0; i < zero; i++) {
                    out.print(0);
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
        try (JeffAndDigits instance = new JeffAndDigits()) {
            instance.solve();
        }
    }
}
