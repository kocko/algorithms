package codeforces.contests1001_1100.problemset1009;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinimumTernaryString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        boolean twoFound = false;
        StringBuilder a = new StringBuilder(), b = new StringBuilder(), c = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (x[i] == '2') {
                twoFound = true;
            }
            if (x[i] == '0' || x[i] == '2') {
                if (twoFound) c.append(x[i]);
                else a.append(x[i]);
            } else {
                b.append(x[i]);
            }
        }
        out.println(a.append(b).append(c));
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
        try (MinimumTernaryString instance = new MinimumTernaryString()) {
            instance.solve();
        }
    }
}
