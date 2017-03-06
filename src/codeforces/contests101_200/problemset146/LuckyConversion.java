package codeforces.contests101_200.problemset146;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LuckyConversion implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        int a = 0, b = 0, diff = 0, n = x.length;
        for (int i = 0; i < n; i++) {
            if (x[i] != y[i]) {
                if (x[i] == '4' && y[i] == '7') {
                    a++;
                } else if (x[i] == '7' && y[i] == '4') {
                    b++;
                }
                diff++;
            }
        }
        int result = Math.min(a, b);
        diff -= 2 * result;
        out.println(result + diff);
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
        try (LuckyConversion instance = new LuckyConversion()) {
            instance.solve();
        }
    }
}
