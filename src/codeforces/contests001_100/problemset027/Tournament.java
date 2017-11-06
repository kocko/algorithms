package codeforces.contests001_100.problemset027;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Tournament implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), max = (n * (n - 1)) / 2;
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        for (int i = 0; i < max - 1; i++) {
            int u = in.ni(), v = in.ni();
            outDegree[u]++;
            inDegree[v]++;
        }
        int[] result = new int[2];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] + outDegree[i] < n - 1) {
                result[idx++] = i;
            }
        }
        if (inDegree[result[0]] <= inDegree[result[1]]) {
            out.println(result[0] + " " + result[1]);
        } else {
            out.println(result[1] + " " + result[0]);
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
        try (Tournament instance = new Tournament()) {
            instance.solve();
        }
    }
}
