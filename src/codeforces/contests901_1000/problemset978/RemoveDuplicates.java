package codeforces.contests901_1000.problemset978;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RemoveDuplicates implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Integer> result = new ArrayList<>();
        boolean[] has = new boolean[1001];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        for (int i = n - 1; i >= 0; i--) {
            if (has[x[i]]) continue;
            result.add(x[i]);
            has[x[i]] = true;
        }
        out.println(result.size());
        for (int i = result.size() - 1; i >= 0; i--) {
            out.print(result.get(i));
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
        try (RemoveDuplicates instance = new RemoveDuplicates()) {
            instance.solve();
        }
    }
}
