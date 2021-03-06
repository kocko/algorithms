package codeforces.contests301_400.problemset397;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OnSegmentsOwnPoints implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        boolean[] taken = new boolean[101];
        int x = in.ni(), y = in.ni();
        for (int i = 0; i < n - 1; i++) {
            int left = in.ni(), right = in.ni();
            for (int j = left; j < right; j++) {
                taken[j] = true;
            }
        }
        int ans = 0;
        for (int i = x; i < y; i++) if (!taken[i]) ans++;
        out.println(ans);
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
        try (OnSegmentsOwnPoints instance = new OnSegmentsOwnPoints()) {
            instance.solve();
        }
    }
}
