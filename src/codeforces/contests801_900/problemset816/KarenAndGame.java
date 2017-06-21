package codeforces.contests801_900.problemset816;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class KarenAndGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        String ROW = "row", COL = "col";
        int n = in.ni(), m = in.ni();
        int[][] x = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] = in.ni();
            }
        }
        if (n > m) {
            String t = ROW;
            ROW = COL;
            COL = t;
            x = rotate(x);
            int k = n;
            n = m;
            m = k;
        }
        List<String> log = new ArrayList<>();
        int[] min = new int[n];
        Arrays.fill(min, 1000);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min[i] = Math.min(min[i], x[i][j]);  
            }   
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            int cnt = min[i];
            for (int j = 0; j < cnt; j++) {
                log.add(ROW + " " + (i + 1));
            }
            Arrays.fill(result[i], cnt);
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (result[i][j] < x[i][j]) {
                    int diff = x[i][j] - result[i][j];
                    for (int k = 0; k < diff; k++) {
                        log.add(COL + " " + (j + 1));
                    }
                    for (int k = 0; k < diff; k++) {
                        for (int row = 0; row < n; row++) {
                            result[row][j]++;
                        }
                    }
                } else if (result[i][j] > x[i][j]) {
                    out.println(-1);
                    return;
                }
            }
        }
        if (verify(result, x)) {
            out.println(log.size());
            log.forEach(out::println);
        } else {
            out.println(-1);
        }
    }
    
    private boolean verify(int[][] given, int[][] expected) {
        int n = given.length, m = given[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (given[i][j] != expected[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int[][] rotate(int[][] x) {
        int n = x.length, m = x[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = x[i][j];
            }
        }
        return result;
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
        try (KarenAndGame instance = new KarenAndGame()) {
            instance.solve();
        }
    }
}
