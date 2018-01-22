package codeforces.contests201_300.problemset246;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Math.*;

public class ColorfulGraph implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] c = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = in.ni();
            map.putIfAbsent(c[i], new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            if (c[u] != c[v]) {
                Set<Integer> set = map.getOrDefault(c[u], new HashSet<>());
                set.add(c[v]);
                map.put(c[u], set);
                
                set = map.getOrDefault(c[v], new HashSet<>());
                set.add(c[u]);
                map.put(c[v], set);
            }
        }
        int max = -1, idx = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            if (size > max) {
                max = size;
                idx = entry.getKey();
            } else if (max == size) {
                idx = Math.min(idx, entry.getKey());
            }
        }
        out.println(idx);
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
        try (ColorfulGraph instance = new ColorfulGraph()) {
            instance.solve();
        }
    }
}
