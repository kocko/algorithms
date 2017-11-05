package codeforces.contests001_100.problemset069;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bets implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] bestTime = new int[n + 1];
        int[] winner = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bestTime[i] = Integer.MAX_VALUE;
            winner[i] = -1;
        }
        int[] c = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            int left = in.ni(), right = in.ni(), time = in.ni();
            c[i] = in.ni();
            for (int section = left; section <= right; section++) {
                if (time < bestTime[section]) {
                    bestTime[section] = time;
                    winner[section] = i;
                }
            }
        }
        int result = 0;
        for (int section = 1; section <= n; section++) {
            if (winner[section] != -1) {
                result += c[winner[section]];
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
        try (Bets instance = new Bets()) {
            instance.solve();
        }
    }
}
