package codeforces.contests901_1000.problemset987;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThreeDisplays implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] size = new int[n], cost = new int[n], next = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = in.ni();
            next[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            cost[i] = in.ni();
        }
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (size[j] > size[i] && cost[j] < min) {
                    min = cost[j];
                }
            }
            next[i] = min;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (size[j] > size[i] && next[j] != Integer.MAX_VALUE) {
                    result = Math.min(cost[i] + cost[j] + next[j], result);
                }
            }
        }
        out.println(result == Integer.MAX_VALUE ? -1 : result);
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
        try (ThreeDisplays instance = new ThreeDisplays()) {
            instance.solve();
        }
    }
}