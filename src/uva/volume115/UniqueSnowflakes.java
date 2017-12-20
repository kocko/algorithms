package uva.volume115;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            if (n == 0) {
                out.println(0);
                continue;
            }
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.ni();
            }
            int result = 1;
            int left = 0, right = 0;
            Set<Integer> map = new HashSet<>();
            map.add(x[0]);
            while (left < n && ++right < n) {
                if (map.contains(x[right])) {
                    while (map.contains(x[right])) {
                        map.remove(x[left]);
                        left++;
                    }
                } else {
                    result = Math.max(result, right - left + 1);
                }
                map.add(x[right]);
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
        try (Main instance = new Main()) {
            instance.solve();
        }
    }
}
