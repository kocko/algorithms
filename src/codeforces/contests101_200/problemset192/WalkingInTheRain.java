package codeforces.contests101_200.problemset192;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WalkingInTheRain implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        if (n == 1) {
            out.println(in.ni());
            return;
        }
        int[] tiles = new int[n];
        for (int i = 0; i < n; i++) {
            tiles[i] = in.ni();
        }
        int result = 0;
        out: while (true) {
            if (tiles[0] == -1 || tiles[n - 1] == -1) break;
            for (int i = 1; i < n - 2; i++) {
                if (tiles[i] == -1 && tiles[i + 1] == -1) break out;
            }
            int min = 10001; int index = -1;
            for (int i = 0; i < n; i++) {
                if (tiles[i] != -1 && tiles[i] < min) {
                    min = tiles[i];
                    index = i;
                }
            }
            result = min;
            tiles[index] = -1;
        }
        out.println(result);
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

    public static void main(String[] args) {
        new WalkingInTheRain().solve();
    }
}
