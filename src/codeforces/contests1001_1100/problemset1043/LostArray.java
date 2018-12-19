package codeforces.contests1001_1100.problemset1043;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LostArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.ni();
        }
        List<Integer> result = new ArrayList<>();
        for (int k = 1; k <= n; k++) {
            Integer[] x = new Integer[k];
            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                int idx = (i - 1) % k;
                if (x[idx] == null) {
                    x[idx] = a[i] - a[i - 1];
                } else {
                    ok &= x[idx] == a[i] - a[i - 1];
                }
            }
            if (ok) {
                result.add(k);
            }
        }
        out.println(result.size());
        for (int s : result) {
            out.print(s);
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
        try (LostArray instance = new LostArray()) {
            instance.solve();
        }
    }
}
