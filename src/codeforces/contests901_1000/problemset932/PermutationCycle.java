package codeforces.contests901_1000.problemset932;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class PermutationCycle implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), a = in.ni(), b = in.ni(), gcd = gcd(a, b);
        if (n % gcd != 0) {
            out.println(~0);
            return;
        } 
        long x = -1, y = -1;
        for (long k = 0; a * k <= n; k++) {
            if ((n - a * k) % b == 0) {
                x = k;
                y = (n - k * a) / b;
                break;
            }
        }
        if (x == -1) {
            out.println(~0);
            return;
        }
        int start = 1;
        for (int i = 0; i < x; i++) {
            shift(start, a);
            start += a;
        }
        for (int i = 0; i < y; i++) {
            shift(start, b);
            start += b;
        }
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);   
    }
    
    private void shift(int start, int step) {
        for (int i = start; i < start + step; i++) {
            if (i == start + step - 1) {
                out.print(start);
            } else {
                out.print(i + 1);
            }
            out.print(' ');
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
        try (PermutationCycle instance = new PermutationCycle()) {
            instance.solve();
        }
    }
}
