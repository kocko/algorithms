package codeforces.contests701_800.problemset777;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AlyonaAndSpreadsheet implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni(), m = in.ni();
        int[][] x = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] = in.ni();
            }
        }
        int[] max = new int[n + 1];
        Arrays.fill(max, 1);
        for (int j = 0; j < m; j++) {
            int idx = 1, size = 1;
            while (idx < n) {
                if (x[idx][j] < x[idx - 1][j]) {
                    size = 1;
                } else {
                    size++;
                }
                max[idx + 1] = Math.max(max[idx + 1], size);
                idx++;
            }
        }
        
        int k = in.ni();
        while (k-- > 0) {
            int left = in.ni(), right = in.ni();
            if (left == right) {
                out.println("Yes");
            } else {
                int size = right - left + 1;
                out.println(max[right] >= size ? "Yes" : "No");
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
        try (AlyonaAndSpreadsheet instance = new AlyonaAndSpreadsheet()) {
            instance.solve();
        }
    }
}
