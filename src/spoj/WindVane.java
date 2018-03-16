package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class WindVane implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('N', 0);
        put('E', 1);
        put('S', 2);
        put('W', 3);
    }};

    private final Map<Integer, Character> inverse = new HashMap<Integer, Character>() {{
        put(0, 'N');
        put(1, 'E');
        put(2, 'S');
        put(3, 'W');
    }};
    
    public void solve() {
        int m = in.ni(), n = in.ni();
        int[][] initial = new int[m][n];
        for (int i = 0; i < m; i++) {
            char[] row = in.next().toCharArray();
            for (int j = 0; j < n; j++) {
                initial[i][j] = map.get(row[j]);
            }
        }
        FenwickTree tree = new FenwickTree();
        int q = in.ni();
        while (q-- > 0) {
            char type = in.next().charAt(0);
            if (type == 'C') {
                int x1 = in.ni(), y1 = in.ni(), x2 = in.ni(), y2 = in.ni();
                int direction = in.ni() == 0 ? 1 : -1;
                tree.update(x1, y1, x2, y2, direction);
            } else {
                int x = in.ni(), y = in.ni(), score = initial[x - 1][y - 1] + tree.query(x, y);
                if (score < 0) {
                    score = 4 + (score % 4);
                }
                score %= 4;
                out.println(inverse.get(score));
            }
        }
    }
    
    private class FenwickTree {
        private int MAX_M = 1000, MAX_N = 1000;
        private int[][] tree = new int[1001][1001];
        
        private void update(int x1, int y1, int x2, int y2, int delta) {
            for (int x = x1; x <= MAX_M; x += (x & -x)) {
                for (int y = y1; y <= MAX_N; y += (y & -y)) {
                    tree[x][y] += delta;
                }
                for (int y = y2 + 1; y <= MAX_N; y += (y & -y)) {
                    tree[x][y] -= delta;
                }
            }
            for (int x = x2 + 1; x <= MAX_M; x += (x & -x)) {
                for (int y = y1; y <= MAX_N; y += (y & -y)) {
                    tree[x][y] -= delta;
                }
                for (int y = y2 + 1; y <= MAX_N; y += (y & -y)) {
                    tree[x][y] += delta;
                }
            }
        }
        
        public int query(int x, int y) {
            int result = 0;
            for (int i = x; i > 0; i -= (i & -i)) {
                for (int j = y; j > 0; j -= (j & -j)) {
                    result += tree[i][j];
                }
            }
            return result;
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
        try (WindVane instance = new WindVane()) {
            instance.solve();
        }
    }
}
