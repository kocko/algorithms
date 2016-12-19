package codeforces.contests701_800.problemset746;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GreenAndBlackTea implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), g = in.ni(), b = in.ni();
        int last = 0;
        char c = '\u0000';
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            char next = 'B';
            if (g >= b) {
                next = 'G';
            }
            if (c == next && last == k) {
                if (b == g) {
                    if (c == 'G') next = 'B';
                    else next = 'B';
                } else if (b < g) {
                    if (b == 0) {
                        out.println("NO"); return;
                    }
                    next = 'B';
                } else {
                    if (g == 0) {
                        out.println("NO"); return;
                    }
                    next = 'G';
                }
            } else if (c != next) {
                last = 1;
            } else if (last < k) {
                last++;
            }
            if (next == 'G') g--;
            else b--;
            c = next;
            result[i] = next;
        }
        for (char x : result) {
            out.print(x);
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
        try (GreenAndBlackTea instance = new GreenAndBlackTea()) {
            instance.solve();
        }
    }
}
