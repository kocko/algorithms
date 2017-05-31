package codeforces.contests401_500.problemset402;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Nuts implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int k = in.ni(), a = in.ni(), divisors = in.ni(), volume = in.ni();
        int sections = a / volume + (a % volume != 0 ? 1 : 0);
        int boxes = 0;
        while (divisors > 0 && sections > 0) {
            if (divisors >= k - 1) {
                divisors -= (k - 1);
                sections -= k;
            } else {
                sections -= (divisors + 1);
                divisors = 0;
            }
            boxes++;
        }
        if (sections > 0) {
            boxes += sections;
        }
        out.println(boxes);
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
        try (Nuts instance = new Nuts()) {
            instance.solve();
        }
    }
}
