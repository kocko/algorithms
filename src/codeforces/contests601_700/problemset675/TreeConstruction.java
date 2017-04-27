package codeforces.contests601_700.problemset675;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TreeConstruction implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
   
    public void solve() {
        int n = in.ni();
        TreeSet<Integer> tree = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        tree.add(in.ni());
        map.put(tree.first(), 0);
        for (int i = 1; i < n; i++) {
            int next = in.ni();
            Integer lo = tree.lower(next);
            Integer hi = tree.higher(next);
            if (hi == null) {
                out.print(lo);
            } else if (lo == null) {
                out.print(hi);
            } else {
                out.print(map.get(hi) < map.get(lo) ? lo : hi);
            }
            out.print(' ');
            tree.add(next);
            map.put(next, i);
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
        try (TreeConstruction instance = new TreeConstruction()) {
            instance.solve();
        }
    }
}
