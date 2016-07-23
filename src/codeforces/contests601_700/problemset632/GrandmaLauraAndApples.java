package codeforces.contests601_700.problemset632;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GrandmaLauraAndApples implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni(), p = in.ni();

        String[] buyers = new String[n];
        for (int i = 0; i < n; i++) {
            buyers[i] = in.next();
        }
        long total = p / 2, apples = 1;
        for (int i = n - 2; i >= 0; i--) {
            String next = buyers[i];
            apples <<= 1;
            total += (apples * p) / 2;
            if ("halfplus".equals(next)) {
                apples++;
                total += p / 2;
            }
        }
        out.println(total);
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

    public static void main(String[] args) {
        new GrandmaLauraAndApples().solve();
    }
}
