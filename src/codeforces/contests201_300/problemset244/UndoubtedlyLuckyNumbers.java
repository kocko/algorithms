package codeforces.contests201_300.problemset244;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UndoubtedlyLuckyNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        this.n = in.nl();
        recurse(0, -1);
        out.println(result);
    }
    
    private long n;
    private int result; 
    
    private void recurse(int mask, long num) {
        int bits = popCount(mask);
        if (bits == 0) {
            for (int i = 1; i <= 9; i++) {
                if (i <= n) {
                    result++;
                    recurse(mask | (1 << i), i);
                }
            }
        } else if (bits == 1) {
            for (int i = 0; i <= 9; i++) {
                if (num * 10 + i <= n) {
                    result++;
                    recurse(mask | (1 << i), num * 10 + i);
                }
            }
        } else if (bits == 2) {
            for (int i = 0; i <= 9; i++) {
                if ((mask & (1 << i)) > 0 && num * 10 + i <= n) {
                    result++;
                    recurse(mask, num * 10 + i);
                }
            }
        }
    }
    
    private int popCount(int n) {
        int result = 0;
        while (n > 0) {
            n -= (n & -n);
            result++;
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
        try (UndoubtedlyLuckyNumbers instance = new UndoubtedlyLuckyNumbers()) {
            instance.solve();
        }
    }
}
