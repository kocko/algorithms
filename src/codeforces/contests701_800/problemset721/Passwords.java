package codeforces.contests701_800.problemset721;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Passwords implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        long best = 1, worst = 1;
        int[] map = new int[101];
        for (int i = 0; i < n; i++) {
            int next = in.next().length();
            map[next]++;
        }
        int password = in.next().length();

        long total = 0;
        for (int i = 1; i < password; i++) {
            total += map[i];
            best += map[i];
            worst += map[i];
        }
        if (total > 0) {
            best += (total / k) * 5;
        }
        total += map[password] - 1;
        worst += map[password] - 1;
        if (total > 0) {
            worst += (total / k) * 5;
        }

        out.println(best + " " + worst);
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
        try (Passwords instance = new Passwords()) {
            instance.solve();
        }
    }
}
