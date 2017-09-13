package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DecodeTheStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n, m;
        while ((n = in.ni()) != 0 && (m = in.ni()) != 0) {
            int[] p = new int[n];
            for (int i = 0; i < n; i++) p[i] = in.ni() - 1;
            char[] word = in.nextLine().toCharArray();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i][p[i]] = 1;
            }
            int[][] result = multiply(new int[][]{p}, power(matrix, m + 1));
            for (int i = 0; i < n; i++) {
                out.print(word[result[0][i]]);
            }
            out.println();
        }
    }

    private int[][] power(int[][] m, int p) {
        int n = m.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) result[i][i] = 1;
        while (p > 0) {
            if (p % 2 == 1) {
                result = multiply(result, m);
            }
            m = multiply(m, m);
            p >>= 1;
        }
        return result;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
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

        public String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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
        try (DecodeTheStrings instance = new DecodeTheStrings()) {
            instance.solve();
        }
    }
}
