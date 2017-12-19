package uva.volume120;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class JustPruneTheList implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), m = in.ni(), result = 0;
            Map<Integer, Integer> count = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int next = in.ni();
                count.put(next, count.getOrDefault(next, 0) + 1);
            }
            for (int i = 0; i < m; i++) {
                int next = in.ni();
                Integer c = count.get(next);
                if (c == null) {
                    result++;
                } else {
                    if (c == 1) count.remove(next);
                    else count.put(next, c - 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                result += entry.getValue();
            }
            out.println(result);
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
        try (JustPruneTheList instance = new JustPruneTheList()) {
            instance.solve();
        }
    }
}
