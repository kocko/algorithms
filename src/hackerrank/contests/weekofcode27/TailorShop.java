package hackerrank.contests.weekofcode27;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class TailorShop implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), p = in.ni();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(in.ni());
        }
        Collections.sort(a);
        boolean[] used = new boolean[1000000];
        long total = 0L;
        for (Integer x : a) {
            int need;
            if (x % p == 0) {
                need = x / p;
            } else {
                need = x / p + 1;
            }
            while (used[need]) {
                need++;
            }
            used[need] = true;
            total += need;
        }
        out.println(total);
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
        try (TailorShop instance = new TailorShop()) {
            instance.solve();
        }
    }
}
