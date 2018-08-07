package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class ClosestNumber implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        for (int i = 0; i < 2; i++) {
            result = 0;
            n = in.nl();
            recurse(1, 0);
            out.print(result);    
            out.print(' ');    
        }
    }
    
    private final long MAX = (long) 1e18; 
    private long n, result;
    
    private long[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
    
    private void recurse(long product, int idx) {
        if (product >= n || idx >= primes.length || MAX / primes[idx] < product) {
            if (abs(n - product) < abs (n - result)) {
                result = product;
            } else if (abs(n - product) == abs(n - result)) {
                result = min(product, result);
            }
            return;
        }
        recurse(product * primes[idx], idx);
        recurse(product, idx + 1);
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
        try (ClosestNumber instance = new ClosestNumber()) {
            instance.solve();
        }
    }
}
