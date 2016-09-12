package codeforces.gyms.acm.year2015.syria;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Chance implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private int[] primes = {2, 3, 5, 7, 11, 13, 17};
    
    private int[] storage = new int[100001];
    
    public void solve() {
        int t = in.ni();
        init();
        while (t-- > 0) {
            int a = in.ni(), b = in.ni();
            if (a == 0) a = 1;
            if (b == 0) b = 1;
            out.println(storage[b] - storage[a - 1]);
        }
    }
    
    private void init() {
        for (int i = 2; i <= 100000; i++) {
            int count = BigInteger.valueOf(i).bitCount();
            boolean ok = false;
            for (int p : primes) {
                if (p == count) {
                    ok = true;
                    break;
                }
            }
            storage[i] = storage[i - 1];
            if (ok) {
                storage[i]++;
            }
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
        try (Chance instance = new Chance()) {
            instance.solve();
        }
    }
}
