package codeforces.contests901_1000.problemset919;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Substring implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        label = in.next().toCharArray();
        int[] degree = new int[n];
        for (int i = 0; i < m; i++) {
            int u = in.ni() - 1, v = in.ni() - 1;
            if (graph.get(u).add(v)) {
                degree[v]++;
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            for (int v : graph.get(u)) {
                degree[v]--;
                if (degree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (count < n) {
            out.println(-1);
            return;
        }
        
        dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            dp[i] = null;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] score = recurse(i);
            for (int j = 0; j < 26; j++) {
                if (score[j] > max) {
                    max = dp[i][j];
                }
            }
        }
        out.println(max);
    }
    
    private List<Set<Integer>> graph = new ArrayList<>();
    
    private int[][] dp;
    private char[] label;
    
    private int[] recurse(int u) {
        if (dp[u] != null) return dp[u];
        
        int[] result = new int[26];
        for (int v : graph.get(u)) {
            int[] temp = recurse(v);
            for (int i = 0; i < 26; i++) {
                result[i] = Math.max(result[i], temp[i]);
            }
        }
        result[label[u] - 'a']++;
        return dp[u] = result;
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
        try (Substring instance = new Substring()) {
            instance.solve();
        }
    }
}
