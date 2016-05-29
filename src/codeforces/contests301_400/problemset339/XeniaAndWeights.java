package codeforces.contests301_400.problemset339;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class XeniaAndWeights implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    char[] graph;
    int m;
    List<String> paths = new ArrayList<>();

    public void solve() {
        graph = in.next().toCharArray();
        m = in.ni();
        dfs(0, true, 0, 0, -1, "");
        if (!paths.isEmpty()) {
            out.println("YES");
            out.println(paths.get(0).trim());
        } else {
            out.println("NO");
        }
    }

    private void dfs(int level, boolean left, int a, int b, int last, String path) {
        if (level == m || !paths.isEmpty()) {
            paths.add(path);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (i != last && graph[i] == '1') {
                if (left) {
                    if (a + i + 1 > b) {
                        dfs(level + 1, false, a + i + 1, b, i, path + " " + (i + 1));
                    }
                } else {
                    if (b + i + 1 > a) {
                        dfs(level + 1, true, a, b + i + 1, i, path + " " + (i + 1));
                    }
                }
            }
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
        new XeniaAndWeights().solve();
    }
}