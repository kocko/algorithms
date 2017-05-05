package codeforces.contests401_500.problemset482;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DiversePermutation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] result = new int[n];
        int idx = 0;
        result[idx] = 1;
        boolean[] used = new boolean[n + 1];
        used[1] = true;
        for (int offset = k; offset >= 1; offset--) {
            if (result[idx] - offset > 0 && !used[result[idx] - offset]) {
                result[idx + 1] = result[idx] - offset;
                used[result[idx + 1]] = true;
                idx++;
            } else if (result[idx] + offset <= n && !used[result[idx] + offset]) {
                result[idx + 1] = result[idx] + offset;
                used[result[idx + 1]] = true;
                idx++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                result[++idx] = i;
                used[i] = true;
            }
        }
        for (int i : result) {
            out.print(i);
            out.print(' ');
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
        try (DiversePermutation instance = new DiversePermutation()) {
            instance.solve();
        }
    }
}
