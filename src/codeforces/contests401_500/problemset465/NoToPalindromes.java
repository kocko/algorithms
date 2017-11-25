package codeforces.contests401_500.problemset465;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NoToPalindromes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), p = in.ni(), i;
        char[] x = in.next().toCharArray();
        for (++x[i = n - 1]; i >= 0 && i < n;) {
            if (x[i] - 'a' == p) {
                x[i] = 'a';
                if (--i >= 0) {
                    x[i]++;
                }
            } else if ((i >= 1 && x[i] == x[i - 1]) || (i >= 2 && x[i] == x[i - 2])) {
                x[i]++;
            } else {
                i++;
            }
        }
        if (i == -1) {
            out.println("NO");
        } else {
            for (char c : x) out.print(c);
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
        try (NoToPalindromes instance = new NoToPalindromes()) {
            instance.solve();
        }
    }
}
