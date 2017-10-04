package codeforces.contests401_500.problemset435;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PashaMaximizes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int k = in.ni(), idx = 0, n = x.length;
        while (k > 0 && idx < n) {
            int max = -1, index = idx + 1;
            for (int i = idx + 1; i < Math.min(n, idx + k + 1); i++) {
                if (x[i] > max) {
                    max = x[i];
                    index = i;
                }
            }
            if (max > x[idx]) {
                k -= (index - idx);
                while (index > idx) {
                    x[index] = (char) ((x[index] + x[index - 1]) - (x[index - 1] = x[index]));
                    index--;
                }
            }
            idx++;
        }
        for (char c : x) out.print(c);
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
        try (PashaMaximizes instance = new PashaMaximizes()) {
            instance.solve();
        }
    }
}
