package codeforces.contests1001_1100.problemset1015;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StarsDrawingEasy implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] x = new char[n][m];
        for (int i = 0; i < n; i++) {
            x[i] = in.next().toCharArray();
        }
        List<int[]> result = new ArrayList<>();
        boolean[][] ok = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] == '*') {
                    int[] star = new int[3];
                    star[0] = i + 1;
                    star[1] = j + 1;
                    int up = i - 1, down = i + 1, left = j - 1, right = j + 1;
                    int size = 0;
                    while (up >= 0 && down < n && left >= 0 && right < m) {
                        if (x[up][j] == '*' && x[down][j] == '*' && x[i][left] == '*' && x[i][right] == '*') {
                            size++;
                            ok[i][j] = ok[i][left] = ok[i][right] = ok[up][j] = ok[down][j] = true;
                            up--;
                            down++;
                            left--;
                            right++;
                        } else break;
                    }
                    if (ok[i][j] && size > 0) {
                        star[2] = size;
                        result.add(star);
                    }
                }
            }
        }
        boolean f = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] == '*') f &= ok[i][j];   
            }
        }
        if (f) {
            out.println(result.size());
            for (int[] star : result) {
                for (int i : star) {
                    out.print(i);
                    out.print(' ');
                }
                out.println();
            }
        } else out.println(-1);
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
        try (StarsDrawingEasy instance = new StarsDrawingEasy()) {
            instance.solve();
        }
    }
}
