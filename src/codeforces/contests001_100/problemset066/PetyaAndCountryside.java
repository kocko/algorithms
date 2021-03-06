package codeforces.contests001_100.problemset066;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PetyaAndCountryside implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = in.ni();
        int max = 0;
        for (int start = 0; start < n; start++) {
            int left = 0;
            for (int i = start - 1; i >= 0; i--) {
                if (x[i] <= x[i + 1]) left++;
                else break;
            }
            int right = 0;
            for (int i = start + 1; i < n; i++) {
                if (x[i] <= x[i - 1]) right++;
                else break;
            }
            max = Math.max(max, right + left + 1);
        }
        out.println(max);
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
        try (PetyaAndCountryside instance = new PetyaAndCountryside()) {
            instance.solve();
        }
    }
}
