package codeforces.contests001_100.problemset026;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Arrays.fill;

public class AlmostPrime implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] sieve = new int[3001];
        fill(sieve, -1);
        for (int i = 2; i <= n; i++) {
            if (sieve[i] == -1) {
                for (int j = i; j <= 3000; j += i) {
                    if (sieve[j] == -1) sieve[j] = 1;
                    else sieve[j]++;
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (sieve[i] == 2) {
                cnt++;
            }
        }
        out.println(cnt);
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
        try (AlmostPrime instance = new AlmostPrime()) {
            instance.solve();
        }
    }
}
