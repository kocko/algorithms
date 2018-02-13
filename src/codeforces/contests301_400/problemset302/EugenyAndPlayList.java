package codeforces.contests301_400.problemset302;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EugenyAndPlayList implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] start = new int[n + 1];
        int[] end = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int c = in.ni(), t = in.ni(), total = c * t;
            start[i] = end[i - 1] + 1;
            end[i] = start[i] + total - 1;
        }
        int idx = 1;
        while (m-- > 0) {
            int t = in.ni();
            while (!(t >= start[idx] && t <= end[idx])) {
                idx++;
            }
            out.println(idx);
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
        try (EugenyAndPlayList instance = new EugenyAndPlayList()) {
            instance.solve();
        }
    }
}
