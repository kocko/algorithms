package codeforces.contests801_900.problemset879;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TableTennis implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long k = in.nl();
        int[] power = new int[n];
        int idx = -1;
        for (int i = 0; i < n; i++) {
            power[i] = in.ni();
            if (power[i] == n) idx = i;
        }
        int[] cnt = new int[n];
        boolean[] tail = new boolean[n];
        for (int i = 0; i < idx; i++) {
            if (!tail[i]) {
                for (int j = i + 1; j < idx; j++) {
                    if (power[i] > power[j]) {
                        cnt[i]++;
                        tail[j] = true;
                    } else {
                        tail[i] = true;
                        cnt[j]++;
                        break;
                    }
                    if (cnt[i] == k) {
                        out.println(power[i]);
                        return;
                    }
                }
            }
        }
        out.println(power[idx]);
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
        try (TableTennis instance = new TableTennis()) {
            instance.solve();
        }
    }
}
