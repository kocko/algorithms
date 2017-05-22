package codeforces.contests401_500.problemset401;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VanyaAndCards implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), x = in.ni();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += in.ni();
        }
        int result = 0;
        while (sum != 0) {
            if (sum > 0) {
                if (sum - x > 0) {
                    sum -= x;
                } else {
                    sum = 0;
                }
            } else {
                if (sum + x < 0) {
                    sum += x;
                } else {
                    sum = 0;
                }
            }
            result++;
        }
        out.println(result);
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
        try (VanyaAndCards instance = new VanyaAndCards()) {
            instance.solve();
        }
    }
}
