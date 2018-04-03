package codeforces.contests901_1000.problemset959;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MahmoudAndEhabAndTheMessage implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), m = in.ni();
        String[] words = new String[n];
        int[] group = new int[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.next();
        }
        long[] score = new long[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nl();
        }
        Map<String, Integer> map = new HashMap<>();
        long[] min = new long[k];
        for (int i = 0; i < k; i++) {
            min[i] = Integer.MAX_VALUE;
            int count = in.ni();
            for (int j = 0; j < count; j++) {
                int next = in.ni() - 1;
                map.put(words[next], i);
                min[i] = Math.min(min[i], score[next]);
            }
        }
        long result = 0;
        for (int i = 0; i < m; i++) {
            result += min[map.get(in.next())];
        }
        out.println(result);
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
        try (MahmoudAndEhabAndTheMessage instance = new MahmoudAndEhabAndTheMessage()) {
            instance.solve();
        }
    }
}
