package codeforces.contests701_800.problemset764;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TimofeyAndATree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni();
        int[] c = new int[n + 1];
        int[][] edges = new int[n - 1][2]; 
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni(), v = in.ni();
            edges[i] = new int[] { u , v };
        }
        for (int i = 1; i <= n; i++) {
            c[i] = in.ni();
        }
        int[] result = {-1, -1};
        for (int i = 0; i < n - 1; i++) {
            int[] edge = edges[i];
            if (c[edge[0]] != c[edge[1]]) {
                if (result[0] == -1 && result[1] == -1) {
                    result = edge;
                } else {
                    boolean matching = false;
                    out: for (int idx : result) {
                        for (int k = 0; k < 2; k++) {
                            if (idx == edge[k]) {
                                result = new int[]{edge[k]};
                                matching = true;
                                break out;
                            }
                        }
                    }
                    if (!matching) {
                        out.println("NO");
                        return;
                    }
                }
            }
        }
        out.println("YES");
        if (result[0] == -1) {
            out.println(1);
        } else {
            out.println(result[0]);
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
        try (TimofeyAndATree instance = new TimofeyAndATree()) {
            instance.solve();
        }
    }
}
