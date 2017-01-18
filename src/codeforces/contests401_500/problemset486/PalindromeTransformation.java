package codeforces.contests401_500.problemset486;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PalindromeTransformation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), p = in.ni() - 1;
        char[] c = in.next().toCharArray();
        int result = 0;
        int mid = n / 2 + (n % 2);
        if (p >= mid) {
            p = n - p - 1;
        }
        int min = n + 1, max = -1;
        for (int i = 0; i < mid; i++) {
            if (c[i] != c[n - i - 1]) {
                result += minDist(c[i], c[n - i - 1]);
                if (i < min) min = i;
                if (i > max) max = i;
            }
        }
        if (max >= 0 && min < n) {
            if (p > max) {
                result += p - min;
            } else if (p < min) {
                result += max - p;
            } else {
                result += max - min;
                result += Math.min(max - p, p - min);
            }
        }
        out.println(result);
    }
    
    private int minDist(char a, char b) {
        if (a > b) {
            char t = a;
            a = b;
            b = t;
        }
        return Math.min(b - a, a - 'a' + 'z' - b + 1);
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
        try (PalindromeTransformation instance = new PalindromeTransformation()) {
            instance.solve();
        }
    }
}
