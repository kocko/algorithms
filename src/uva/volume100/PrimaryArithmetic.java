package uva.volume100;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PrimaryArithmetic implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String a, b;
        while (true) {
            a = in.next();
            b = in.next();
            if ("0".equals(a) & "0".equals(b)) break;
            char[] x = a.toCharArray(), y = b.toCharArray();
            int i = x.length - 1, j = y.length - 1;
            int carry = 0, count = 0;
            while (i >= 0 || j >= 0) {
                int p = (i >= 0) ? (x[i] - '0') : 0;
                int q = (j >= 0) ? (y[j] - '0') : 0;
                if (carry > 0) count++;
                int total = p + q + carry;
                carry = total >= 10 ? 1 : 0;
                i--;
                j--;
            }
            if (carry > 0) count++;
            if (count == 0) {
                out.println("No carry operation.");
            } else {
                out.printf("%d carry operation", count);
                if (count > 1) out.print('s');
                out.println(".");
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
        try (PrimaryArithmetic instance = new PrimaryArithmetic()) {
            instance.solve();
        }
    }
}
