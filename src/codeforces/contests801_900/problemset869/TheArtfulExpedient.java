package codeforces.contests801_900.problemset869;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheArtfulExpedient implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n], b = new int[n];
        boolean[] has = new boolean[2000005];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
            has[a[i]] = true;
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.ni();
            has[b[i]] = true;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.println(a[i] ^ b[j]);
                if (has[a[i] ^ b[j]]) {
                    count ^= 1;
                }
            }
        }
        out.println((count & 1) == 0 ? "Karen" : "Koyomi");
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
        try (TheArtfulExpedient instance = new TheArtfulExpedient()) {
            instance.solve();
        }
    }
}
