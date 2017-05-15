package codeforces.contests801_900.problemset808;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LuckyYear implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl();
        String x = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i = x.length() - 1; i >= 1; i--) {
            sb.append('0');
        }
        if (x.charAt(0) != '9') {
            sb.append((char) (x.charAt(0) + 1));
        } else {
            sb.append("01");
        }
        int k = Integer.valueOf(sb.reverse().toString());
        out.println(k - n);
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
        try (LuckyYear instance = new LuckyYear()) {
            instance.solve();
        }
    }
}
