package codeforces.contests001_100.problemset063;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SettlersTraining implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] cnt = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            cnt[next]++;
        }
        int result = 0;
        int[] add = new int[k + 1];
        while (cnt[k] < n) {
            for (int i = 1; i < k; i++) {
                if (cnt[i] > 0) {
                    add[i + 1] = 1;
                    cnt[i]--;
                }
            }
            for (int i = 1; i <= k; i++) {
                cnt[i] += add[i];
            }
            add = new int[k + 1];
            result++;
        }
        out.println(result);
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
        try (SettlersTraining instance = new SettlersTraining()) {
            instance.solve();
        }
    }
}
