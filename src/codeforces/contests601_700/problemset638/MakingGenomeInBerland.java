package codeforces.contests601_700.problemset638;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakingGenomeInBerland implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    StringBuilder sb = new StringBuilder();
    
    char[] adj = new char[26];
    boolean[] mark = new boolean[26];
    int[] inDegree = new int[26];
    
    public void solve() {
        int n = in.ni();
        for (int i = 0; i < n; i++) {
            char[] next = in.next().toCharArray();
            for (int j = 0; j < next.length; j++) {
                if (j != next.length - 1) {
                    adj[next[j] - 'a'] = next[j + 1];
                    inDegree[next[j + 1] - 'a']++;
                }
                mark[next[j] - 'a'] = true;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0 && mark[i]) {
                dfs(i);
            }
        }
        
        out.println(sb.toString());
    }
    
    boolean[] vis = new boolean[26];
    
    private void dfs(int u) {
        vis[u] = true;
        sb.append((char)('a' + u));
        if (adj[u] != '\u0000' && !vis[adj[u] - 'a']) {
            dfs(adj[u] - 'a');
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

    public static void main(String[] args) {
        new MakingGenomeInBerland().solve();
    }
}
