package codeforces.contests201_300.problemset221;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LittleElephantAndArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        final int MAX_N = (int) 1e5 + 1, MAX_GOOD = 600;
        int[] x = new int[n + 1], cnt = new int[MAX_N];
        Set<Integer> possible = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            x[i] = in.ni();
            if (x[i] < MAX_N) {
                cnt[x[i]]++;
                if (cnt[x[i]] >= x[i]) {
                    possible.add(x[i]);
                }
            }
        }
        int[] good = new int[possible.size()];
        int idx = 0;
        for (int value : possible) {
            good[idx++] = value;
        }
        int[][] prefix = new int[MAX_GOOD][MAX_N];
        for (int i = 0; i < good.length; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i][j - 1] + (x[j] == good[i] ? 1 : 0);
            }
        }
        while (q-- > 0) {
            int left = in.ni(), right = in.ni();
            int result = 0;
            for (int i = 0; i < good.length; i++) {
                if (prefix[i][right] - prefix[i][left - 1] == good[i]) {
                    result++;
                }
            }
            out.println(result);
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
        try (LittleElephantAndArray instance = new LittleElephantAndArray()) {
            instance.solve();
        }
    }
}
