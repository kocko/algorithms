package codeforces.contests901_1000.problemset999;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ReversingEncryption implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        x = in.next().toCharArray();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                reverse(i);
            }
        }
        for (char c : x) {
            out.print(c);
        }
    }
    
    private int n;
    private char[] x;
    
    private void reverse(int d) {
        int h = d / 2;
        for (int i = 0; i < h; i++) {
            char temp = x[i];
            x[i] = x[d - i - 1];
            x[d - i - 1] = temp;
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
        try (ReversingEncryption instance = new ReversingEncryption()) {
            instance.solve();
        }
    }
}
