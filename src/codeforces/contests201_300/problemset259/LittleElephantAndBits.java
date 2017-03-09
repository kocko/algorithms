package codeforces.contests201_300.problemset259;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittleElephantAndBits implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        char[] result = new char[n - 1];
        boolean skip = false;
        for (int i = 0; i < n; i++) {
            if (x[i] == '1') {
                if (skip) {
                    result[i - 1] = '1';
                } else {
                    if (i != n - 1) result[i] = '1';
                }
            } else {
                if (!skip) {
                    skip = true;
                    continue;
                }   
                if (skip) {
                    result[i - 1] = '0';
                }
            }
        }
        for (char c : result) {
            out.print(c);
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
        try (LittleElephantAndBits instance = new LittleElephantAndBits()) {
            instance.solve();
        }
    }
}
