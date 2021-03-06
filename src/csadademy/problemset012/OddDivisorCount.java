package csadademy.problemset012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OddDivisorCount implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b = in.ni();
        int result = 0;
        for (int i = a; i <= b; i++) {
            if (i == 1) result++;
            else if (ok(i)) {
                result++;
            }
        }
        out.println(result);
    }
    
    private boolean ok(int x) {
        int count = 0;
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0) count++;
        }
        return count % 2 == 1;
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
        try (OddDivisorCount instance = new OddDivisorCount()) {
            instance.solve();
        }
    }
}
