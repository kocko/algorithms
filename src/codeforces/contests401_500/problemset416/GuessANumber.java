package codeforces.contests401_500.problemset416;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GuessANumber implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), inf = (int) 1e9 + 1, left = -inf, right = inf, value;
        String sign, answer;
        while (n-- > 0) {
            sign = in.next();
            value = in.ni();
            answer = in.next();
            if (answer.charAt(0) == 'N') {
                if (">".equals(sign)) sign = "<=";
                else if ("<".equals(sign)) sign = ">=";
                else if ("<=".equals(sign)) sign = ">";
                else sign = "<";
            }

            if (">".equals(sign)) value++;
            else if ("<".equals(sign)) value--;

            int a, b;
            if (sign.charAt(0) == '<') {
                a = -inf;
                b = value;
            } else {
                a = value;
                b = inf;
            }
            if (a > right || b < left) {
                out.println("Impossible");
                return;
            } else {
                left = Math.max(left, a);
                right = Math.min(right, b);
            }
            if (left > right) {
                out.println("Impossible");
                return;
            }
        }
        out.println(left);
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
        try (GuessANumber instance = new GuessANumber()) {
            instance.solve();
        }
    }
}
