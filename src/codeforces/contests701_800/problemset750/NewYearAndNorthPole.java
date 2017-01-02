package codeforces.contests701_800.problemset750;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewYearAndNorthPole implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int current = 0;
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            int dist = in.ni();
            String dir = in.next();
            if (current == 20000 && !"North".equals(dir)) {
                ok = false;
                break;
            } else if (current == 0 && !"South".equals(dir)) {
                ok = false;
                break;
            } else if ("South".equals(dir)) {
                current += dist; 
            } else if ("North".equals(dir)) {
                current -= dist;
            }
            if (current < 0 || current > 20000) {
                ok = false;
                break;
            }
        }
        out.println(ok && current == 0 ? "YES" : "NO");
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
        try (NewYearAndNorthPole instance = new NewYearAndNorthPole()) {
            instance.solve();
        }
    }
}
