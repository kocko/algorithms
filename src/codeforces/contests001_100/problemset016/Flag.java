package codeforces.contests001_100.problemset016;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Flag implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), last = -1;
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            char[] c = in.next().toCharArray();
            if (allAreEqual(c) && (c[0] - '0') != last) {
                last = c[0] - '0';
            } else {
                ok = false;
                break;
            }
        }
        out.println(ok ? "YES" : "NO");
    }
    
    private boolean allAreEqual(char[] c) {
        boolean result = true;
        for (int i = 1; i < c.length; i++) {
            result &= c[i] == c[0];
        }
        return result;
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
        try (Flag instance = new Flag()) {
            instance.solve();
        }
    }
}
