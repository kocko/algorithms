package codeforces.contests101_200.problemset122;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LuckySum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        recurse(4);
        recurse(7);
        Collections.sort(lucky);
        long a = in.nl(), b = in.nl(), result = 0L;
        while (a <= b) {
            long next = next(a), size = next - a + 1;
            if (a + size > b) {
                size = b - a + 1;
            }
            result += next * size;
            a = next + 1;
        }
        out.println(result);
    }

    private List<Long> lucky = new ArrayList<>();

    private void recurse(long base) {
        if (base <= (long) 1e10) {
            lucky.add(base);
            recurse(base * 10 + 4);
            recurse(base * 10 + 7);
        }
    }

    private long next(long a) {
        for (Long num : lucky) {
            if (num >= a) {
                return num;
            }
        }
        return 0;
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
        try (LuckySum instance = new LuckySum()) {
            instance.solve();
        }
    }
}
