package codeforces.contests701_800.problemset776;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SherlockAndHisGirlfriend implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] sieve = new int[n + 2];
        for (int i = 2; i <= n + 1; i++) {
            if (sieve[i] == 0) {
                sieve[i] = 1;
                for (long j = ((long)i * i); j <= n + 1L; j += i) {
                    sieve[(int) j] = 2;
                }
            }
        }
        if (n > 2) {
            out.println(2);
        } else {
            out.println(1);
        }
        for (int i = 2; i <= n + 1; i++) {
            out.print(sieve[i]);
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
        try (SherlockAndHisGirlfriend instance = new SherlockAndHisGirlfriend()) {
            instance.solve();
        }
    }
}
