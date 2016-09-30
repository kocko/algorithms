package codeforces.contests201_300.problemset271;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PrimeMatrix implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] r = new int[n], c = new int[m];
        int[] found = new int[100001];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int next = in.ni();
                if (found[next] == 0) {
                    found[next] = findNextPrime(next);
                }
                int diff = found[next] - next;
                r[i] += diff;
                c[j] += diff;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (r[i] < min) {
                min = r[i];
            }
        }
        for (int i = 0; i < m; i++) {
            if (c[i] < min) {
                min = c[i];
            }
        }
        out.println(min);
    }

    private int findNextPrime(int x) {
        while (!isPrime(x)) {
            x++;
        }
        return x;
    }

    private boolean isPrime(int x) {
        if (x == 2) return true;
        if (x == 1 || x % 2 == 0) return false;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
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
        try (PrimeMatrix instance = new PrimeMatrix()) {
            instance.solve();
        }
    }
}
