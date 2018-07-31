package codeforces.contests1001_1100.problemset1015;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PointsInSegments implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        boolean[] has = new boolean[m + 1];
        for (int i = 0; i < n; i++) {
            int left = in.ni(), right = in.ni();
            for (int j = left; j <= right; j++) {
                has[j] = true;
            }
        }
        int result = 0;
        for (int i = 1; i <= m; i++) {
            if (!has[i]) result++;
        }
        out.println(result);
        for (int i = 1; i <= m; i++) {
            if (!has[i]) {
                out.print(i);
                out.print(' ');
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
        try (PointsInSegments instance = new PointsInSegments()) {
            instance.solve();
        }
    }
}
