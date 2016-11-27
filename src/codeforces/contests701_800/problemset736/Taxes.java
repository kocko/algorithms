package codeforces.contests701_800.problemset736;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Taxes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n % 2 == 0) {
            if (n == 2) {
                out.println(1);
            } else {
                out.println(2);
            }
        } else {
            if (n > 7) {
                if (isPrime(n)) {
                    out.println(1);
                } else {
                    if (isPrime(n - 2)) {
                        out.println(2);
                    } else {
                        out.println(3);
                    }
                }
            } else {
                out.println(1);
            }
        }
    }
    
    private boolean isPrime(int num) {
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
        try (Taxes instance = new Taxes()) {
            instance.solve();
        }
    }
}
