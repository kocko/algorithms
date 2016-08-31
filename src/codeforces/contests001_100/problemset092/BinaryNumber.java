package codeforces.contests001_100.problemset092;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BinaryNumber implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String a = in.next();
        int n = a.length();
        char[] x = new char[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = a.charAt(i - 1);
        }
        int start = n, result = 0;
        while (start > 1 || (start == 1 && x[0] != '\u0000')) {
            if (x[start] == '0') start--;
            else {
                int current = start;
                while (x[current] == '1') {
                    x[current--] ='0';
                }
                x[current] = '1';
            }
            result++;
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
        try (BinaryNumber instance = new BinaryNumber()) {
            instance.solve();
        }
    }
}
