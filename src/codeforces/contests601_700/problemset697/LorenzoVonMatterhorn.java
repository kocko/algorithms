package codeforces.contests601_700.problemset697;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Long.max;

public class LorenzoVonMatterhorn implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int q = in.ni();
        while (q-- > 0) {
            int type = in.ni();
            if (type == 1) {
                long u = in.nl(), v = in.nl(), w = in.nl();
                while (u != v) {
                    long max = max(u, v);
                    updates.put(max, updates.getOrDefault(max, 0L) + w);
                    if (u > v) u >>= 1;
                    else v >>= 1;
                }
            } else {
                out.println(walk(in.nl(), in.nl()));
            }
        }
    }

    private Map<Long, Long> updates = new HashMap<>();

    private long walk(long u, long v) {
        long result = 0;
        while (u != v) {
            long max = max(u, v);
            result += updates.getOrDefault(max, 0L);
            if (u > v) u >>= 1;
            else v >>= 1;
        }
        return result;
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
        try (LorenzoVonMatterhorn instance = new LorenzoVonMatterhorn()) {
            instance.solve();
        }
    }
}
