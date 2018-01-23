package codeforces.contests101_200.problemset127;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class CanvasFrames implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), result = 0;
        int[] cnt = new int[101];
        for (int i = 0; i < n; i++) {
            cnt[in.ni()]++;
        }
        boolean found;
        do {
            found = false;
            int count = 0;
            for (int i = 1; i <= 100; i++) {
                if (count == 2) {
                    found = true;
                    result++;
                    break;
                }
                if (cnt[i] >= 2) {
                    count++;
                    cnt[i] -= 2;
                    i--;
                }
            }
        } while (found);
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

    public static void main(String[] args) throws IOException {
        try (CanvasFrames instance = new CanvasFrames()) {
            instance.solve();
        }
    }
}
