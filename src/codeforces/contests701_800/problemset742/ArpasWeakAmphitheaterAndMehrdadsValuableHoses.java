package codeforces.contests701_800.problemset742;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ArpasWeakAmphitheaterAndMehrdadsValuableHoses implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root;
        private int[] size;
        
        private DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }
        
        private int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }
        
        private void join(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    y = (x ^ y) ^ (x = y);
                }
                root[y] = x;
                size[x] += size[y];
            }
        }
    }
    
    public void solve() {
        int n = in.ni(), pairs = in.ni(), max = in.ni();
        weights = new int[n + 1];
        beauty = new int[n + 1];
        for (int i = 0; i < n; i++) {
            weights[i] = in.ni();
        }
        for (int i = 0; i < n; i++) {
            beauty[i] = in.ni();
        }
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 0; i < pairs; i++) {
            dsu.join(in.ni() - 1, in.ni() - 1);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.root(i);
            List<Integer> list = map.getOrDefault(root, new ArrayList<>());
            list.add(i);
            map.put(root, map.getOrDefault(i, list));
        }
        data = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            data.add(entry.getValue());
        }
        k = data.size();
        dp = new int[k][max + 1];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], -1);
        }
        out.println(recurse(0, max));
    }

    private List<List<Integer>> data;
    private int k;
    private int[] weights, beauty;
    private int[][] dp;
    
    private int recurse(int idx, int weight) {
        if (idx == k || weight == 0) return 0;
        
        if (dp[idx][weight] != -1) return dp[idx][weight];
        
        int ans = recurse(idx + 1, weight);
        
        int totalWeight = 0, totalBeauty = 0;
        for (int node : data.get(idx)) {
            totalWeight += weights[node];
            totalBeauty += beauty[node];
            if (weight >= weights[node]) {
                ans = Math.max(ans, beauty[node] + recurse(idx + 1, weight - weights[node]));
            }
        }
        
        if (weight >= totalWeight) {
            ans = Math.max(ans, totalBeauty + recurse(idx + 1, weight - totalWeight));
        }
        
        return dp[idx][weight] = ans;
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
        try (ArpasWeakAmphitheaterAndMehrdadsValuableHoses instance = new ArpasWeakAmphitheaterAndMehrdadsValuableHoses()) {
            instance.solve();
        }
    }
}
