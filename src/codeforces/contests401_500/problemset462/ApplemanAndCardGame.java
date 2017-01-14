package codeforces.contests401_500.problemset462;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ApplemanAndCardGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), k = in.nl();
        char[] c = in.next().toCharArray();
        long[] cnt = new long[26];
        for (char a : c) {
            cnt[a - 'A']++;
        }
        Arrays.sort(cnt);
        long result = 0L;
        for (int i = 25; i >= 0 && k > 0; i--) {
            if (cnt[i] <= k) {
                result += (cnt[i] * cnt[i]);
                k -= cnt[i];
            } else {
                result += k * k;
                k = 0;
            }
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
        try (ApplemanAndCardGame instance = new ApplemanAndCardGame()) {
            instance.solve();
        }
    }
}
