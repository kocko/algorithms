package codeforces.contests701_800.problemset702;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PowersOfTwo implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long count = 0L;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long x = in.nl();
            for (int j = 1; j <= 30; j++) {
                long d = (1 << j) - x;
                if (map.containsKey(d)) {
                    count += map.get(d);
                }
            }
            Long v = map.getOrDefault(x, 0L);
            map.put(x, v + 1);
        }
        out.println(count);
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
        try (PowersOfTwo instance = new PowersOfTwo()) {
            instance.solve();
        }
    }
}
