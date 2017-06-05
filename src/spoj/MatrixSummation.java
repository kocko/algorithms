package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MatrixSummation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class FenwickTree {
        private final int MAX = 1050;
        private int[][] tree = new int[MAX][MAX];
        
        private void update(int x, int y, int value) {
            for (int i = x; i <= MAX; i += (i & -i))
                for (int j = y; j <= MAX; j += (j & -j)) 
                    tree[i][j] += value;
        }
        
        private int query(int x, int y) {
            int result = 0;
            for (int i = x; i > 0; i -= (i & -i)) {
                for (int j = y; j > 0; j -= (j & -j)) {
                    result += tree[i][j];
                }
            }
            return result;
        }
        
    }

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            FenwickTree tree = new FenwickTree();
            String query;
            while (!(query = in.next()).equals("END")) {
                if ("SET".equals(query)) {
                    int x = in.ni(), y = in.ni(), value = in.ni();
                    int prev = tree.query(x + 1, y + 1) + tree.query(x, y) - tree.query(x, y + 1) - tree.query(x + 1, y);
                    tree.update(x + 1, y + 1, value - prev);
                } else {
                    int x1 = in.ni(), y1 = in.ni(), x2 = in.ni(), y2 = in.ni();
                    int result = tree.query(x2 + 1, y2 + 1) + tree.query(x1, y1) - tree.query(x1, y2 + 1) - tree.query(x2 + 1, y1); 
                    out.println(result);
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

    public static void main(String[] args) throws IOException {
        try (MatrixSummation instance = new MatrixSummation()) {
            instance.solve();
        }
    }
}
