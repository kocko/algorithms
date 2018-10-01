package codeforces.contests1001_1100.problemset1040;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class PalindromeDance implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), a = in.ni(), b = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        int result = 0;
        for (int i = 0; i < n / 2; i++) {
            if (x[i] == 2 && x[n - i - 1] == 2) {
                result += 2 * min(a, b);
                continue;
            }
            if (x[i] != 2 && x[n - i - 1] != 2) {
                if (x[i] != x[n - i - 1]) {
                    out.println(-1);
                    return;
                }
            } else {
                if (x[i] == 2) {
                    if (x[n - i - 1] == 0) result += a;
                    else result += b; 
                } else {
                    if (x[i] == 0) result += a;
                    else result += b;
                }
            }
        }
        if (n % 2 == 1 && x[n / 2] == 2) {
            result += min(a, b);
        }
        out.println(result);
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
        try (PalindromeDance instance = new PalindromeDance()) {
            instance.solve();
        }
    }
}
