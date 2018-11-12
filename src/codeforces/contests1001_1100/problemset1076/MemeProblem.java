package codeforces.contests1001_1100.problemset1076;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

public class MemeProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            long d = in.nl();
            double a, b;
            if (d == 0) {
                a = b = 0.;
            } else if (d < 4) {
                out.println("N");
                continue;
            } else if (d == 4) {
                a = b = 2.;
            } else {
                long D = d * d - 4 * d;
                double sqrt = sqrt(D);
                if (d >= sqrt) {
                    a = (d + sqrt) / 2.;
                    b = d - a;
                } else {
                    out.println("N");
                    continue;
                }
            }
            out.printf("Y %f %f\n", a, b);
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
        try (MemeProblem instance = new MemeProblem()) {
            instance.solve();
        }
    }
}
