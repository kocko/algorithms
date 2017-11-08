package codeforces.contests101_200.problemset114;

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
import java.util.stream.Collectors;

public class PfastInc implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), p = in.ni();
        String[] names = new String[n];
        Map<String, Integer> invertedIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            names[i] = in.next();
            invertedIndex.put(names[i], i);
        }
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) graph[i][j] = 1;
        while (p-- > 0) {
            String u = in.next(), v = in.next();
            int x = invertedIndex.get(u), y = invertedIndex.get(v);
            graph[x][y] = graph[y][x] = 0;
        }
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i < 1 << n; i++) {
            if (isClique(i, graph)) {
                if (popCount(i) > result.size()) {
                    Set<Integer> temp = new HashSet<>();
                    for (int j = 0; j < 16; j++) {
                        if ((i & (1 << j)) > 0) {
                            temp.add(j);
                        }
                    }
                    result = temp;
                }
            }
        }
        List<String> output = result.stream().map(i -> names[i]).sorted().collect(Collectors.toList());
        out.println(output.size());
        output.forEach(out::println);
    }

    private int popCount(int n) {
        int ans = 0;
        while (n > 0) {
            ans++;
            n -= (n & -n);
        }
        return ans;
    }

    private boolean isClique(int n, int[][] graph) {
        List<Integer> x = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            if ((n & (1 << i)) > 0) x.add(i);
        }
        if (x.size() == 0) return false;
        boolean ok = true;
        for (int i = 0; i < x.size(); i++) {
            for (int j = 0; j < x.size(); j++) {
                ok &= graph[x.get(i)][x.get(j)] == 1;
            }
        }
        return ok;
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
        try (PfastInc instance = new PfastInc()) {
            instance.solve();
        }
    }
}
