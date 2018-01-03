package codeforces.contests301_400.problemset365;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GoodNumber implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), result = 0;
        while (n-- > 0) {
            result += good(in.ni(), k);
        }
        out.println(result);
    }

    private int good(int n, int k) {
        boolean[] has = new boolean[10];
        while (n > 0) {
            int rem = n % 10;
            has[rem] = true;
            n /= 10;
        }
        boolean all = true;
        for (int i = 0; i <= k; i++) {
            all &= has[i];
        }
        return all ? 1 : 0;
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
        try (GoodNumber instance = new GoodNumber()) {
            instance.solve();
        }
    }
}
