package codeforces.contests901_1000.problemset960;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CheckTheString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        boolean ok = true;
        int n = x.length;
        if (n < 3) {
            out.println("NO");
            return;
        }
        int[] cnt = new int[3];
        for (int i = 1; i < n; i++) {
            ok &= ((x[i] == x[i - 1]) || (x[i] > x[i - 1]));
        }
        for (char ch : x) {
            cnt[ch - 'a']++;
        }
        ok &= ((cnt[0] > 0 && cnt[1] > 0));
        ok &= ((cnt[2] == cnt[0]) || (cnt[2] == cnt[1]));
        out.println(ok ? "YES" : "NO");
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
        try (CheckTheString instance = new CheckTheString()) {
            instance.solve();
        }
    }
}
