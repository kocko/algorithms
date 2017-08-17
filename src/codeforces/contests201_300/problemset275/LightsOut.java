package codeforces.contests201_300.problemset275;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LightsOut implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        for (int i = 0; i < 4; i++) Arrays.fill(lights[i], 1);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                int times = in.ni();
                update(i, j, times % 2);
            }
        }
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                out.print(lights[i][j]);
            }
            out.println();
        }
    }
    
    private int[][] lights = new int[5][5];
    
    private void update(int i, int j, int times) {
        lights[i][j] ^= times;
        lights[i - 1][j] ^= times;
        lights[i][j - 1] ^= times;
        lights[i + 1][j] ^= times;
        lights[i][j + 1] ^= times;
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
        try (LightsOut instance = new LightsOut()) {
            instance.solve();
        }
    }
}
