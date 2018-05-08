package codeforces.contests901_1000.problemset977;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ConsecutiveSubsequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        Map<Integer, Integer> last = new HashMap<>();
        int[] size = new int[n];
        int[] next = new int[n];
        int max = 1, idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            int value = x[i];
            last.put(value, i);
            int nxt = last.getOrDefault(value + 1, -1);
            if (nxt != -1) {
                size[i] = size[nxt] + 1;
                next[i] = nxt;
                if (size[i] > max) {
                    max = size[i];
                    idx = i;
                }
            } else {
                size[i] = 1;
            }
        }
        out.println(max);
        for (int i = 0; i < max; i++) {
            out.print(idx + 1);
            out.print(' ');
            idx = next[idx];
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
        try (ConsecutiveSubsequence instance = new ConsecutiveSubsequence()) {
            instance.solve();
        }
    }
}
