package codeforces.contests1101_1200.problemset1110;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MeaninglessGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        final int[] arr = {1, 1, 5, 1, 21, 1, 85, 73, 341, 89, 1365, 1, 5461, 4681, 21845, 1, 87381, 1, 349525, 299593, 1398101, 178481, 5592405, 1082401};
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 3; i <= (1 << 25 - 1); i = i * 2 + 1) {
            map.put(i, arr[idx++]);
        }
        int q = in.ni();
        while (q-- > 0) {
            int n = in.ni();
            if (map.containsKey(n)) {
                out.println(map.get(n));
            } else {
                int x = 1;
                while (x < n) {
                    x <<= 1;
                    x |= 1;
                }
                out.println(x);
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
        try (MeaninglessGame instance = new MeaninglessGame()) {
            instance.solve();
        }
    }
}
