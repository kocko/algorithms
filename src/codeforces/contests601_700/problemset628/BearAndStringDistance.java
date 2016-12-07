package codeforces.contests601_700.problemset628;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BearAndStringDistance implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        char[] x = in.next().toCharArray();
        int longest = 0;
        for (char c : x) {
            longest += Math.max(c - 'a', 'z' - c);
        }
        if (longest < k) {
            out.println(-1);
            return;
        }
        for (int i = 0; i < n; i++) {
            char c = x[i];
            if (k == 0) {
                out.print(c);
            } else if (k > 0) {
                int max = Math.max(c - 'a', 'z' - c);
                int min = Math.min(c - 'a', 'z' - c);
                if (k <= max) {
                    char a = (char) (c + k);
                    char b = (char) (c - k);
                    if ('a' <= a && a <= 'z') {
                        out.print(a);
                    } else {
                        out.print(b);
                    }
                    k = 0;
                } else if (k > max) {
                    k -= max;
                    char a = (char) (c + max);
                    char b = (char) (c - max);
                    if ('a' <= a && a <= 'z') {
                        out.print(a);
                    } else {
                        out.print(b);
                    }
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
        try (BearAndStringDistance instance = new BearAndStringDistance()) {
            instance.solve();
        }
    }
}
