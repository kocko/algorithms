package codeforces.contests401_500.problemset456;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FedyaAndMaths implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] pow = in.next().toCharArray();
        int n = pow.length;
        if (pow[0] == '0') {
            out.println(4); return;
        }
        int result = 1;
        int rem;
        if (n > 1) {
            int lastTwo = Integer.parseInt(String.valueOf(pow[n - 2]).concat(String.valueOf(pow[n - 1])));
            rem = lastTwo % 4;
        } else {
            rem = (pow[0] - '0') % 4;
        }
        if (rem == 0) {
            result += 3;
        } else {
            result += 9;
        }
        out.println(result % 5);
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
        try (FedyaAndMaths instance = new FedyaAndMaths()) {
            instance.solve();
        }
    }
}
