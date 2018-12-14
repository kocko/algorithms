package codeforces.contests1001_1100.problemset1084;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.naturalOrder;

public class KvassAndTheFairNut implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long s = in.nl();
        List<Long> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(in.nl());
        }
        v.sort(naturalOrder());
        long current = 0, min = v.get(0);
        for (int i = 1; i < n; i++) {
            long diff = v.get(i) - min;
            if (current + diff <= s) {
                current += diff;
            } else {
                current = s;
                break;
            }
        }
        if (current < s) {
            long remaining = s - current;
            min -= (remaining / n + (remaining % n != 0 ? 1 : 0));
        }
        out.println(min >= 0 ? min : -1);
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
        try (KvassAndTheFairNut instance = new KvassAndTheFairNut()) {
            instance.solve();
        }
    }
}
