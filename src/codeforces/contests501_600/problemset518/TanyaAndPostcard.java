package codeforces.contests501_600.problemset518;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TanyaAndPostcard implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] s = in.next().toCharArray(), t = in.next().toCharArray();
        int yay = 0, whoops = 0;
        int[] cnt = new int[1000];
        for (char c : t) {
            cnt[c]++;
        }
        int n = s.length;
        boolean[] ok = new boolean[n];
        for (int i = 0; i < n; i++) {
            char c = s[i];
            if (cnt[c] > 0) {
                yay++;
                cnt[c]--;
                ok[i] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!ok[i]) {
                char rev, c = s[i];
                if (c >= 'a' && c <= 'z') {
                    rev = (char) ('A' + (c - 'a'));
                } else {
                    rev = (char) ('a' + (c - 'A'));
                }
                if (cnt[rev] > 0) {
                    whoops++;
                    cnt[rev]--;
                    ok[i] = true;
                }
            }
        }
        out.println(yay + " " + whoops);
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
        try (TanyaAndPostcard instance = new TanyaAndPostcard()) {
            instance.solve();
        }
    }
}
