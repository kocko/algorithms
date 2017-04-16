package codeforces.contests701_800.problemset797;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BrokenBST implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni();
        value = new int[n + 1];
        left = new int[n + 1];
        right = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            value[i] = in.ni(); left[i] = in.ni(); right[i] = in.ni();
            if (left[i] != -1) {
                vis[left[i]] = true;
            }
            if (right[i] != -1) {
                vis[right[i]] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                validate(i, -INF, INF);
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!result.contains(value[i])) {
                ans++;
            }
        }
        out.println(ans);
    }
    
    private int[] value;
    private int[] left;
    private int[] right;
    
    private final int INF = (int) (1e9);
    private Set<Integer> result = new HashSet<>();
    
    private void validate(int node, int min, int max) {
        if (value[node] > min && value[node] < max) result.add(value[node]);
        if (left[node] != -1)  validate(left[node], min, Math.min(max, value[node]));
        if (right[node] != -1) validate(right[node], Math.max(min, value[node]), max);
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
        try (BrokenBST instance = new BrokenBST()) {
            instance.solve();
        }
    }
}
