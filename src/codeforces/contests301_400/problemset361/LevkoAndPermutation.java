package codeforces.contests301_400.problemset361;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LevkoAndPermutation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        if (n == k) {
            out.println(-1);
            return;
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        int beauty = n - 1;
        int idx = 1;
        while (beauty - 2 >= k) {
            result[idx + 1] = (result[idx] ^ result[idx + 1]) ^ (result[idx] = result[idx + 1]);
            idx += 2;
            beauty -= 2;
        }
        if (beauty - 1 == k) {
            result[0] = result[idx];
            result[idx] = 1;
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
        try (LevkoAndPermutation instance = new LevkoAndPermutation()) {
            instance.solve();
        }
    }
}
