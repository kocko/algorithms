package codeforces.contests201_300.problemset205;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittleElephantAndRozdil implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int min = (int) 1e9 + 5;
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            min = Math.min(min, x[i]);
        }
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (x[i] == min) {
                if (idx != -1) {
                    out.println("Still Rozdil");
                    return;
                } else {
                    idx = i + 1;
                }
            }
        }
        out.println(idx);
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
        try (LittleElephantAndRozdil instance = new LittleElephantAndRozdil()) {
            instance.solve();
        }
    }
}
