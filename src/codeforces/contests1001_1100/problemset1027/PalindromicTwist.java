package codeforces.contests1001_1100.problemset1027;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class PalindromicTwist implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            solve(in.ni(), in.next().toCharArray());
        }
    }
    
    private void solve(int n, char[] x) {
        int half = n / 2;
        boolean ok = true;
        for (int i = 0; i < half; i++) {
            ok &= (x[i] == x[n - i - 1]) || (x[i] + 1 == x[n - i - 1] - 1) || (x[i] - 1 == x[n - i - 1] + 1);
        }
        out.println(ok ? "YES" : "NO");
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
        try (PalindromicTwist instance = new PalindromicTwist()) {
            instance.solve();
        }
    }
}
