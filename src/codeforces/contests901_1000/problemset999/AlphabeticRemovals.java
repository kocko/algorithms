package codeforces.contests901_1000.problemset999;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AlphabeticRemovals implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        char[] x = in.next().toCharArray();
        List<ArrayDeque<Integer>> left = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            left.add(new ArrayDeque<>());
        }
        for (int i = 0; i < n; i++) {
            left.get(x[i] - 'a').add(i);
        }
        boolean[] deleted = new boolean[n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 26; j++) {
                if (left.get(j).size() > 0) {
                    int idx = left.get(j).pollFirst();
                    deleted[idx] = true;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!deleted[i]) {
                out.print(x[i]);
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
        try (AlphabeticRemovals instance = new AlphabeticRemovals()) {
            instance.solve();
        }
    }
}
