package codeforces.contests001_100.problemset020;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.StringTokenizer;

public class Equation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    void format(double d) {
        out.println(String.format("%.12f", d));
    }
    
    public void solve() {
        long a = in.nl(), b = in.nl(), c = in.nl();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    out.println(-1);
                } else {
                    out.println(0);
                }
            } else {
                out.println(1);
                format((double) -c / b);
            }
        } else {
            if (b == 0) {
                if (c > 0) {
                    out.println(0);
                } else if (c == 0) {
                    out.println(1);
                    format(0);
                } else {
                    out.println(2);
                    double root = Math.sqrt((double) c / a);
                    format(root);
                    format(-root);
                }
            } else {
                long d = b * b - 4 * a * c;
                if (d < 0) {
                    out.println(0);   
                } else if (d == 0) {
                    out.println(1);
                    format((double) -b / (2 * a));
                } else {
                    double sqrt = Math.sqrt(d);
                    double first = (-b - sqrt) / (2 * a);
                    double second = (-b + sqrt) / (2 * a);
                    out.println(2);
                    format(Math.min(first, second));
                    format(Math.max(first, second));
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
        try (Equation instance = new Equation()) {
            instance.solve();
        }
    }
}
