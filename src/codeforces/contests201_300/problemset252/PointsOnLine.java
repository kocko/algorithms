package codeforces.contests201_300.problemset252;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PointsOnLine implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), d = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = in.ni();
        if (n <= 2) {
            out.println(0);
            return;
        }
        long result = 0;
        for (int i = 2; i < n; i++) {
            int left = 0, right = i;
            int ans = right;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (x[i] - x[mid] > d) {
                    left = mid + 1;
                } else {
                    ans = Math.min(ans, mid);
                    right = mid - 1;
                }
            }
            long points = i - ans;
            result += points * (points - 1) / 2;
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

    public static void main(String[] args) throws IOException {
        try (PointsOnLine instance = new PointsOnLine()) {
            instance.solve();
        }
    }
}
