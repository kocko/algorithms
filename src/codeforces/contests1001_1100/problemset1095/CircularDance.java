package codeforces.contests1001_1100.problemset1095;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CircularDance implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = in.ni() - 1;
            data[i][1] = in.ni() - 1;
        }
        int[] result = new int[n];
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            int second = data[idx][0], third = data[idx][1];
            if (data[second][0] == third || data[second][1] == third) {
                result[i] = second;
                result[i + 1] = third;
            } else {
                result[i] = third;
                result[i + 1] = second;
            }
            idx = result[i];
        }
        for (int i = 0; i < n; i++) {
            out.print(result[i] + 1);
            out.print(' ');
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
        try (CircularDance instance = new CircularDance()) {
            instance.solve();
        }
    }
}
