package codeforces.contests1001_1100.problemset1005;

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

public class SummarizeToThePowerOfTwo implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Map<Integer, Integer> map = new HashMap<>();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            x[i] = next;
            map.put(next, map.getOrDefault(next, 0) + 1);
        }
        int delete = 0;
        for (int i = 0; i < n; i++) {
            boolean ok = false;
            for (int j = 1; j <= 31; j++) {
                int need = (1 << j) - x[i];
                if (need == x[i]) {
                    if (map.containsKey(need) && map.get(need) > 1) {
                        ok = true;
                        break;
                    }
                } else {
                    if (map.containsKey(need)) {
                        ok = true;
                        break;
                    }
                }
            }
            if (!ok) delete++;
        }
        out.println(delete);
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
        try (SummarizeToThePowerOfTwo instance = new SummarizeToThePowerOfTwo()) {
            instance.solve();
        }
    }
}
