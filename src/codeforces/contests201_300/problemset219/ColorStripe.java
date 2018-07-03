package codeforces.contests201_300.problemset219;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ColorStripe implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        char[] x = in.next().toCharArray();
        if (k == 2) {
            int a = 0, b = 0;
            for (int i = 0; i < n; i++) {
                if (x[i] == 'A' && i % 2 == 1) a++;
                if (x[i] == 'B' && i % 2 == 0) a++;
            }
            for (int i = 0; i < n; i++) {
                if (x[i] == 'A' && i % 2 == 0) b++;
                if (x[i] == 'B' && i % 2 == 1) b++;
            }
            if (a > b) {
                out.println(b);
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) out.print("B");
                    else out.print("A");
                }
            } else {
                out.println(a);
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) out.print("A");
                    else out.print("B");
                }
            }
        } else {
            int changes = 0;
            int start = 0, current = 1;
            for (int i = 1; i < n; i++) {
                if (x[i] == x[i - 1]) {
                    current++;
                } else {
                    if (current > 1) {
                        char replacement;
                        if (current % 2 == 1) {
                            replacement = findDifferentThan(k, x[i - 1]);
                        } else {
                            replacement = findDifferentThan(k, x[i], x[i - 1]);
                        }
                        for (int j = start + 1; j < i; j += 2) {
                            changes++;
                            x[j] = replacement;
                        }
                    }
                    start = i;
                    current = 1;
                }
            }
            if (current > 1) {
                char replacement = findDifferentThan(k, x[n - 1]);
                for (int j = start + 1; j < n; j += 2) {
                    changes++;
                    x[j] = replacement;
                }
            }
            out.println(changes);
            for (char c : x) out.print(c);
        }
    }

    private char findDifferentThan(int k, char... ignore) {
        for (char ch = 'A'; ch < 'A' + k; ch++) {
            boolean ok = true;
            for (char i : ignore) {
                ok &= ch != i;
            }
            if (ok) return ch;
        }
        return '?';
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
        try (ColorStripe instance = new ColorStripe()) {
            instance.solve();
        }
    }
}