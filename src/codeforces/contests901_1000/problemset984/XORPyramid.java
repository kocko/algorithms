package codeforces.contests901_1000.problemset984;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class XORPyramid implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[][] pyramid = new int[n][n], max = new int[n][n];
        for (int i = 0; i < n; i++) {
            pyramid[0][i] = in.ni();
            max[0][i] = pyramid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                pyramid[i][j] = pyramid[i - 1][j] ^ pyramid[i - 1][j + 1];
                max[i][j] = max(pyramid[i][j], max(max[i - 1][j], max[i - 1][j + 1]));
            }
        }
        if (n > 1) {
            max[n - 1][0] = max(pyramid[n - 1][0], max(max[n - 2][0], max[n - 2][1]));
        }
            
        int q = in.ni();
        while (q-- > 0) {
            int left = in.ni() - 1, right = in.ni() - 1;
            out.println(max[right - left][left]);
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
        try (XORPyramid instance = new XORPyramid()) {
            instance.solve();
        }
    }
}
