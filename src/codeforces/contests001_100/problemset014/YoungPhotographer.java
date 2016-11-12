package codeforces.contests001_100.problemset014;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class YoungPhotographer implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), x = in.ni();
        int[][] segments = new int[n][2];
        int min = 1001, max = 0;
        for (int i = 0; i < n; i++) {
            int a = in.ni(), b = in.ni();
            segments[i][0] = Math.min(a, b);   
            segments[i][1] = Math.max(a, b);
            min = Math.min(segments[i][0], min);
            max = Math.max(segments[i][1], max);
        }
        int result = 1001;
        boolean found = false;
        for (int i = min; i <= max; i++) {
            boolean ok = true;
            for (int[] segment : segments) {
                if (i < segment[0] || i > segment[1]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                found = true;
                int dist = Math.abs(i - x);
                result = Math.min(dist, result);
            }
        }
        out.println(found ? result : -1);
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
        try (YoungPhotographer instance = new YoungPhotographer()) {
            instance.solve();
        }
    }
}
