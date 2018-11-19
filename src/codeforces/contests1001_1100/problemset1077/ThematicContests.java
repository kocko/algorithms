package codeforces.contests1001_1100.problemset1077;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ThematicContests implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] type = new int[n];
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            type[i] = in.ni();
            count.put(type[i], count.getOrDefault(type[i], 0) + 1);
        }
        List<Integer> types = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            types.add(entry.getValue());
        }
        types.sort(Comparator.naturalOrder());
        int result = 0, p = types.size();
        for (int base = 1; base <= types.get(p - 1); base++) {
            int pos = p - 1;
            int current = base;
            int res = current;
            while (current % 2 == 0 && pos > 0) {
                current /= 2;
                --pos;
                if (types.get(pos) < current) break;
                res += current;
            }
            result = Math.max(res, result);
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
        try (ThematicContests instance = new ThematicContests()) {
            instance.solve();
        }
    }
}
