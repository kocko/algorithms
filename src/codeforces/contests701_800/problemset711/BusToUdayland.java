package codeforces.contests701_800.problemset711;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BusToUdayland implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        String[] list = new String[n];
        boolean found = false;
        for (int i = 0; i < n; i++) {
            char[] next = in.next().toCharArray();
            if (!found) {
                if ((next[0] == 'O' && next[1] == 'O')) {
                    next[0] = next[1] = '+';
                    found = true;
                } else if (next[3] == 'O' && next[4] == 'O') {
                    next[3] = next[4] = '+';
                    found = true;
                }
            }
            list[i] = new String(next);
        }
        if (found) {
            out.println("YES");
            Arrays.stream(list).forEach(out::println);
        } else {
            out.println("NO");
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
        try (BusToUdayland instance = new BusToUdayland()) {
            instance.solve();
        }
    }
}
