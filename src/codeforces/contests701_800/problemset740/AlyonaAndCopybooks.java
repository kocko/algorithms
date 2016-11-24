package codeforces.contests701_800.problemset740;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlyonaAndCopybooks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), a = in.nl(), b = in.nl(), c = in.nl();
        long need = (4 - n % 4) % 4;
        long[] x = new long[8];
        x[1] = Math.min(a, b + c);
        x[2] = Math.min(Math.min(2 * x[1], b), 2 * c);
        x[3] = Math.min(Math.min(3 * x[1], x[1] + x[2]), c);
        x[4] = Math.min(x[3] + x[1], x[2] + x[2]);
        x[5] = Math.min(x[4] + x[1], x[3] + x[2]);
        x[6] = Math.min(Math.min(x[5] + x[1], x[4] + x[2]), 2 * x[3]);
        x[7] = Math.min(Math.min(x[6] + x[1], x[5] + x[2]), x[4] + x[3]);
        if (need == 1) {
            out.println(Math.min(x[1], x[5]));
        } else if (need == 2) {
            out.println(Math.min(x[2], x[6]));
        } else if (need == 3) {
            out.println(Math.min(x[3], x[7]));
        } else {
            out.println(0);
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
        try (AlyonaAndCopybooks instance = new AlyonaAndCopybooks()) {
            instance.solve();
        }
    }
}
