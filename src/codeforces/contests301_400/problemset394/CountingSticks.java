package codeforces.contests301_400.problemset394;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class CountingSticks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int a = 0, b = 0, c, n = x.length;
        int i;
        for (i = 0; i < n; i++) {
            if (x[i] == '+') {
                i++;
                break;
            }
            a++;
        }
        for (; i < n; i++) {
            if (x[i] == '=') {
                i++;
                break;
            }
            b++;
        }
        c = n - i;
        if (a + b > c) {
            if (a >= b) {
                a--;
            } else {
                b--;
            }
            c++;
        } else if (a + b < c) {
            c--;
            a++;
        }
        if (a == 0 || b == 0 || c == 0 || (a + b) != c) {
            out.println("Impossible");
        } else {
            while (a-- > 0) out.print("|");
            out.print("+");
            while (b-- > 0) out.print("|");
            out.print("=");
            while (c-- > 0) out.print("|");
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
        try (CountingSticks instance = new CountingSticks()) {
            instance.solve();
        }
    }
}
