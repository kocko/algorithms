package codeforces.contests001_100.problemset082;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DoubleCola implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int k = 0;
        long limit;
        while (true) {
            limit = 5 * ((1 << (k + 1)) - 1);
            if (limit >= n) {
                break;
            }
            k++;
        }
        long start = (5 * ((1 << k) - 1));
        k--;
        int result;
        for (result = 1; result <= 5; result++) {
            if (start + result * (1 << (k + 1)) >= n) break;
        }

        out.println(getName(result));
    }

    private String getName(int n) {
        switch (n) {
            case 1: return "Sheldon";
            case 2: return "Leonard";
            case 3: return "Penny";
            case 4: return "Rajesh";
            case 5: return "Howard";
        }
        return null;
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

    public static void main(String[] args) {
        new DoubleCola().solve();
    }
}
