package codeforces.contests901_1000.problemset962;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MergeEquals implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nl();
        }
        Map<Long, Integer> first = new HashMap<>();
        for (int idx = 0; idx < n; idx++) {
            long current = x[idx];
            while (first.containsKey(current)) {
                first.remove(current);
                current <<= 1L;
            }
            first.put(current, idx);
        }
        long[] result = new long[n];
        for (Map.Entry<Long, Integer> entry : first.entrySet()) {
            result[entry.getValue()] = entry.getKey();
        }
        out.println(first.size());
        for (int i = 0; i < n; i++) {
            if (result[i] != 0) {
                out.print(result[i]);
                out.print(' ');
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
        try (MergeEquals instance = new MergeEquals()) {
            instance.solve();
        }
    }
}
