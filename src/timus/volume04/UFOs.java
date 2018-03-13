package timus.volume04;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UFOs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class FenwickTree {
        private int MAX;
        private int[][][] tree;
        
        private FenwickTree(int n) {
            MAX = n + 1;
            tree = new int[MAX][MAX][MAX];
        }
        
        private void update(int x, int y, int z, int delta) {
            for (int i = x + 1; i < MAX; i += (i & -i)) {
                for (int j = y + 1; j < MAX; j += (j & -j)) {
                    for (int k = z + 1; k < MAX; k += (k & -k)) {
                        tree[i][j][k] += delta;
                    }
                }
            }
        }

        private int query(int x1, int y1, int z1, int x2, int y2, int z2) {
            int ans = 0;
            for (int i = x2 + 1; i > 0; i -= (i & -i)) {
                for (int j = y2 + 1; j > 0; j -= (j & -j)) {
                    for (int k = z2 + 1; k > 0; k -= (k & -k)) {
                        ans += tree[i][j][k];
                    }
                    for (int k = z1; k > 0; k -= (k & -k)) {
                        ans -= tree[i][j][k];
                    }
                }
                for (int j = y1; j > 0; j -= (j & -j)) {
                    for (int k = z2 + 1; k > 0; k -= (k & -k)) {
                        ans -= tree[i][j][k];
                    }
                    for (int k = z1; k > 0; k -= (k & -k)) {
                        ans += tree[i][j][k];
                    }
                }
            }
            for (int i = x1; i > 0; i -= (i & -i)) {
                for (int j = y2 + 1; j > 0; j -= (j & -j)) {
                    for (int k = z2 + 1; k > 0; k -= (k & -k)) {
                        ans -= tree[i][j][k];
                    }
                    for (int k = z1; k > 0; k -= (k & -k)) {
                        ans += tree[i][j][k];
                    }
                }
                for (int j = y1; j > 0; j -= (j & -j)) {
                    for (int k = z2 + 1; k > 0; k -= (k & -k)) {
                        ans += tree[i][j][k];
                    }
                    for (int k = z1; k > 0; k -= (k & -k)) {
                        ans -= tree[i][j][k];
                    }
                }
            }
            return ans;
        }
    }
    
    public void solve() {
        int n = in.ni();
        FenwickTree tree = new FenwickTree(n);
        int type;
        while ((type = in.ni()) != 3) {
            if (type == 1) {
                tree.update(in.ni(), in.ni(), in.ni(), in.ni());
            } else {
                out.println(tree.query(in.ni(), in.ni(), in.ni(), in.ni(), in.ni(), in.ni()));
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

    public static void main(String[] args) throws IOException {
        try (UFOs instance = new UFOs()) {
            instance.solve();
        }
    }
}
