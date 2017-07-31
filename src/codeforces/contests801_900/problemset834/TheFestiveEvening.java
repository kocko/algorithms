package codeforces.contests801_900.problemset834;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TheFestiveEvening implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        char[] x = in.next().toCharArray();
        int[] close = new int[26];
        Arrays.fill(close, -1);
        for (int i = n - 1; i >= 0; i--) {
            int idx = x[i] - 'A';
            if (close[idx] == -1) {
                close[idx] = i;
            }
        }
        int cnt = 0;
        boolean[] open = new boolean[26];
        for (int i = 0; i < n; i++) {
            int idx = x[i] - 'A';
            if (!open[idx]) {
                open[idx] = true;
                cnt++;
            }
            if (cnt > k) {
                out.println("YES");
                return;
            }
            if (close[idx] == i) {
                open[idx] = false;
                cnt--;
            }
        }
        out.println("NO");
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
        try (TheFestiveEvening instance = new TheFestiveEvening()) {
            instance.solve();
        }
    }
}
