package codeforces.contests901_1000.problemset981;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UsefulDecomposition implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] degree = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni(), v = in.ni();
            degree[u]++;
            degree[v]++;
        }
        int count = 0, root = 1;
        for (int i = 1; i <= n; i++) {
            if (degree[i] > 2) {
                count++;
                root = i;
            }
        }
        if (count > 1) {
            out.println("No");
        } else {
            out.println("Yes");
            out.println(degree[root]);
            for (int i = 1; i <= n; i++) {
                if (i != root && degree[i] == 1) {
                    out.println(root + " " + i);
                }
            }
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
        try (UsefulDecomposition instance = new UsefulDecomposition()) {
            instance.solve();
        }
    }
}
