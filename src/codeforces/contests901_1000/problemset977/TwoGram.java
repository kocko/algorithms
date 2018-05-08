package codeforces.contests901_1000.problemset977;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TwoGram implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), max = -1;
        char[] x = in.next().toCharArray();
        char best_a = '?', best_b = '?';
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                char a = (char) ('A' + i), b = (char) ('A' + j);
                int count = 0;
                for (int k = 0; k < n - 1; k++) {
                    if (x[k] == a && x[k + 1] == b) {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    best_a = a;
                    best_b = b;
                }
            }
        }
        out.println(best_a + "" + best_b);
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
        try (TwoGram instance = new TwoGram()) {
            instance.solve();
        }
    }
}
