package codeforces.contests001_100.problemset061;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HardWork implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] x = new String[3];
        for (int i = 0; i < 3; i++) {
            x[i] = clear(in.next().toLowerCase());
        }
        int q = in.ni();
        String[] possible = {x[0] + x[1] + x[2], x[0] + x[2] + x[1], x[1] + x[0] + x[2], x[1] + x[2] + x[0], x[2] + x[1] + x[0], x[2] + x[0] + x[1]};
        while (q-- > 0) {
            String next = clear(in.next().toLowerCase());
            boolean ok = false;
            for (String p : possible) {
                if (p.equals(next)) {
                    ok = true;
                    break;
                }
            }
            out.println(ok ? "ACC" : "WA");
        }
    }

    private String clear(String value) {
        StringBuilder result = new StringBuilder();
        for (char c : value.toCharArray()) {
            if (c >= 'a' && c <= 'z') result.append(c);
        }
        return result.toString();
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
        try (HardWork instance = new HardWork()) {
            instance.solve();
        }
    }
}
