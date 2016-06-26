package codeforces.contests001_100.problemset021;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Stripe2 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.ni();
        long[] list = new long[(int) n + 1];
        long sum = 0;
        
        for (int i = 1; i <= n; i++) {
            list[i] = in.nl();
            sum += list[i];
        }
        if (sum % 3 != 0) {
            out.println(0);
        } else {
            sum /= 3;
            int a = 0;
            long temp = 0;
            long result = 0;
            for (int i = 1; i <= n; i++) {
                temp += list[i];
                if (temp == sum * 2 && i < n) {
                    result += a;
                }
                if (temp == sum) a++;
                
            }
            out.println(result);
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
        try (Stripe2 instance = new Stripe2()) {
            instance.solve();
        }
    }
}
