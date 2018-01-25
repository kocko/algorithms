package codeforces.contests301_400.problemset399;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.lang.String.valueOf;

public class Pages implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), p = in.ni(), k = in.ni();
        if (p - k > 1) {
            print("<<");
        }
        for (int i = p - k; i <= min(n, p + k); i++) {
            if (i <= 0) continue;
            if (i == p) {
                print("(" + i + ")");
            } else {
                print(valueOf(i));
            }
        }
        if (p + k < n) {
            print(">>");
        }
    }
    
    private void print(String x) {
        out.print(x);
        out.print(' ');
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
        try (Pages instance = new Pages()) {
            instance.solve();
        }
    }
}
