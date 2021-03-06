package codeforces.contests1001_1100.problemset1003;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BinaryStringConstructing implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b = in.ni(), x = in.ni();
        StringBuilder sb = new StringBuilder();
        boolean flag = a >= b;
        for (int i = 0; i < x + 1; i++) {
            if (flag) {
                if (i % 2 == 0) {
                    sb.append(0);
                    a--;
                } else {
                    sb.append(1);
                    b--;
                }
            } else {
                if (i % 2 == 0) {
                    sb.append(1);
                    b--;
                } else {
                    sb.append(0);
                    a--;
                }
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                for (int j = 0; j < a; j++) out.print(0);
                a = 0;
            } else {
                for (int j = 0; j < b; j++) out.print(1);
                b = 0;
            }
            out.print(sb.charAt(i));
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
        try (BinaryStringConstructing instance = new BinaryStringConstructing()) {
            instance.solve();
        }
    }
}
