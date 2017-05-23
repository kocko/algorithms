package codeforces.contests601_700.problemset643;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BearAndColors implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] t = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = in.ni();
        }
        int[] cnt;
        int[] result = new int[n + 1];
        for (int left = 1; left <= n; left++) {
            cnt = new int[n + 1];
            int best = 0;
            for (int right = left; right <= n; right++) {
                int color = t[right];
                cnt[color]++;
                if (cnt[color] > cnt[best] || (cnt[color] == cnt[best] && color < best)) {
                    best = color;
                }
                result[best]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            out.print(result[i]);
            out.print(' ');
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
        try (BearAndColors instance = new BearAndColors()) {
            instance.solve();
        }
    }
}
