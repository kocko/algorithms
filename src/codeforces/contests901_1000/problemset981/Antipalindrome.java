package codeforces.contests901_1000.problemset981;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Antipalindrome implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String s = in.next();
        int n = s.length(), result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) {
                String sub = s.substring(i, j);
                if (!isPalindrome(sub)) {
                    result = max(result, sub.length());
                }
            }
        }
        out.println(result);
    }

    private boolean isPalindrome(String a) {
        char[] x = a.toCharArray();
        int n = x.length;
        boolean result = true;
        for (int i = 0; i < n / 2; i++) {
            result &= x[i] == x[n - i - 1];
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
        try (Antipalindrome instance = new Antipalindrome()) {
            instance.solve();
        }
    }
}
