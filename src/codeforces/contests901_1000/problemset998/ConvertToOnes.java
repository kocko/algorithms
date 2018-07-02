package codeforces.contests901_1000.problemset998;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ConvertToOnes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long x = in.ni(), y = in.ni();
        char[] s = in.next().toCharArray();
        int groups = 0, current = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') current++;
            else {
                if (current > 0) {
                    groups++;
                    current = 0;
                }
            }
        }
        if (current > 0) {
            groups++;
        }
        long result = 0;
        if (groups == 1) {
            result = y;
        } else if (groups > 1) {
            long min = Long.MAX_VALUE;
            for (int invert = groups; invert >= 1; invert--) {
                long score = invert * y + (groups - invert) * x;
                if (score < min) min = score;
            }
            result = min;
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
        try (ConvertToOnes instance = new ConvertToOnes()) {
            instance.solve();
        }
    }
}
