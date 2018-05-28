package codeforces.contests901_1000.problemset981;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class BusinessmenProblems implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Map<Integer, Long> codeforces = new HashMap<>();
        for (int i = 0; i < n; i++) {
            codeforces.put(in.ni(), in.nl());
        }
        int m = in.ni();
        Map<Integer, Long> topcoder = new HashMap<>();
        for (int i = 0; i < m; i++) {
            topcoder.put(in.ni(), in.nl());
        }
        long result = 0;
        for (Map.Entry<Integer, Long> entry : codeforces.entrySet()) {
            if (topcoder.containsKey(entry.getKey())) {
                result += max(entry.getValue(), topcoder.get(entry.getKey()));
            } else {
                result += entry.getValue();
            }
        }
        for (Map.Entry<Integer, Long> entry : topcoder.entrySet()) {
            if (!codeforces.containsKey(entry.getKey())) {
                result += entry.getValue();
            }
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
        try (BusinessmenProblems instance = new BusinessmenProblems()) {
            instance.solve();
        }
    }
}
