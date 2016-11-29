package codeforces.contests501_600.problemset584;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DimaAndLisa implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n == 4) {
            out.println(2);
            out.println("2 2");
            return;
        }
        if (isPrime(n)) {
            out.println(1);
            out.println(n);
        } else if (n % 2 == 0) {
            out.println(2);
            int[] primes = findPrimes(n);
            out.println(primes[0] + " " + primes[1]);
        } else {
            out.println(3);
            int[] primes = findPrimes(n - 3);
            out.println(3 + " " + primes[0] + " " + primes[1]);
        }
    }
    
    private int[] findPrimes(int n) {
        int i = 3;
        while (true) {
            if (isPrime(n - i) && isPrime(i)) break;
            i += 2;
        }
        return new int[] {n - i, i};
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0)
            return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
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
        try (DimaAndLisa instance = new DimaAndLisa()) {
            instance.solve();
        }
    }
}
