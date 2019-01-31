package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Famous implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), f = in.ni(), m = in.ni();
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> inv = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < f; i++) {
            String name = in.next();
            map.put(name, idx);
            inv.put(idx, name);
            idx++;
        }
        String[][] pairs = new String[m][2];
        for (int i = 0; i < m; i++) {
            String u = in.next(), v = in.next();
            if (!map.containsKey(u)) {
                map.put(u, idx);
                inv.put(idx, u);
                idx++;
            }
            if (!map.containsKey(v)) {
                map.put(v, idx);
                inv.put(idx, v);
                idx++;
            }
            pairs[i][0] = u;
            pairs[i][1] = v;
        }
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (String[] pair : pairs) {
            int u = map.get(pair[0]), v = map.get(pair[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        List<String> result = new ArrayList<>();
        boolean[] famous = new boolean[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < f; i++) {
            famous[i] = true;
            deque.offerLast(i);
            result.add(inv.get(i));
        }
        int[] cnt = new int[n];
        while (deque.size() > 0) {
            int u = deque.pollFirst();
            for (int v : graph.get(u)) {
                if (!famous[v]) {
                    cnt[v]++;
                    if (cnt[v] == k) {
                        deque.offerLast(v);
                        result.add(inv.get(v));
                        famous[v] = true;
                    }
                }
            }
        }
        result.sort(Comparator.naturalOrder());
        for (String s : result) {
            out.print(s);
            out.print(' ');
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
        try (Famous instance = new Famous()) {
            instance.solve();
        }
    }
}
