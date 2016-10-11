package codeforces.contests501_600.problemset535;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TavasAndSaddas implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] n = in.next().toCharArray();
        StringBuilder binary = new StringBuilder();
        for (char c : n) {
            if (c == '4') {
                binary.append("0");
            } else {
                binary.append("1");
            }
        }
        Integer x = Integer.valueOf(binary.toString(), 2) + 1;
        for (int i = 1; i < binary.length(); i++) {
            x += (1 << i);
        }
        out.println(x);
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
        try (TavasAndSaddas instance = new TavasAndSaddas()) {
            instance.solve();
        }
    }
}
