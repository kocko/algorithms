package codeforces.contests801_900.problemset859;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LazySecurityGuard implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private double round1(double d) {
        return Math.floor(d + 0.5);
    }
    
    public void solve(int k, int ans) {
//        long n = in.nl();
//        out.println(result);
        int n = (int) Math.sqrt(k);
        int result = 2 * n;
        k = k - n * n;
        result += 2 * n;
        if (k == 0) {
            result = result;
        } else if (k <= n) {
            result += 2;
        } else {
            result += 4;
        }
        if (result != ans) {
            throw new RuntimeException("Wrong solution for input [n = " + k + "]; [expected = " + ans + " actual = " + result + "]");
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
        try (LazySecurityGuard instance = new LazySecurityGuard()) {
            instance.solve(1000000, 4000);
            instance.solve(1, 4);
            instance.solve(777122, 3528);
            instance.solve(5, 10);
            instance.solve(7, 12);
            instance.solve(25, 20);
            instance.solve(999, 128);
        }
    }
}
