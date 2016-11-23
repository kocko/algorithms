package codeforces.contests501_600.problemset570;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Elections implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int m = in.ni();
        int[] wins = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int max = -1;
            int winner = 1;
            for (int j = 1; j <= n; j++) {
                int next = in.ni();
                if (next > max) {
                    max = next;
                    winner = j;
                }
            }
            wins[winner]++;
        }
        int result = 1;
        int max = wins[1];
        for (int i = 2; i <= n; i++) {
            if (wins[i] > max) {
                result = i;
                max = wins[i];
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
        try (Elections instance = new Elections()) {
            instance.solve();
        }
    }
}
