package codeforces.contests1001_1100.problemset1087;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinimumDiameterTree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), s = in.ni();
        int[] deg = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni() - 1, v = in.ni() - 1;
            deg[u]++;
            deg[v]++;
        }
        double leaves = 0d;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) leaves++;
        }
        out.println(s / leaves * 2.);
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
        try (MinimumDiameterTree instance = new MinimumDiameterTree()) {
            instance.solve();
        }
    }
}
