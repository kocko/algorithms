package codeforces.contests201_300.problemset277;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LearningLanguages implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
    
    static class DisjointSet {
        int arr[];
        
        public DisjointSet(int n) {
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = i;
            }
        }
        
        public int find(int x) {
            while (x != arr[x]) x = arr[x];
            return x;
        }
        
        public void union(int a, int b) {
            int x = find(a), y = find(b);
            if (x != y) {
                arr[x] = y;
            }
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni();
        DisjointSet dsu = new DisjointSet(m);
        boolean[] used = new boolean[m + 1];
        int result = 0;
        boolean talkable = false;
        for (int i = 0; i < n; i++) {
            int a = in.ni();
            if (a == 0) result++;
            else if (a > 1) {
                talkable = true;
                int root = in.ni();
                for (int j = 1; j < a; j++) {
                    int lang = in.ni();
                    dsu.union(root, lang);
                    used[lang] = true;
                }
            } else {
                talkable = true;
                int lang = in.ni();
                used[lang] = true;
            }
        }
        if (talkable) {
            for (int i = 1; i <= m; i++) {
                if (used[i] && dsu.arr[i] == i) result++;
            }
            out.println(result - 1);
        } else {
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

    public static void main(String[] args) {
        new LearningLanguages().solve();
    }
}
