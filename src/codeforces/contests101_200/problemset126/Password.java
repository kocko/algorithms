package codeforces.contests101_200.problemset126;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Password implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String x = in.next();
        char[] s = x.toCharArray();
        int l = 0, r = 0, n = s.length;
        int[] z = new int[n];
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && s[r - l] == s[r]) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < n && s[r - l] == s[r]) {
                        r++;
                    }
                    z[i] = r - l;
                    r--;
                }
            }
        }
        int result = 0, max = 0;
        for (int i = 1; i < n; i++) {
            if (z[i] == n - i && max >= n - i) {
                result = n - i;
                break;
            }
            max = Math.max(z[i], max);
        }
        if (result == 0) {
            out.println("Just a legend");
        } else {
            out.println(x.substring(0, result));
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
        try (Password instance = new Password()) {
            instance.solve();
        }
    }
}
