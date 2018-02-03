package codeforces.contests901_1000.problemset920;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WaterTheGarden implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), k = in.ni();
            int[] time = new int[n];
            for (int i = 0; i < n; i++) {
                time[i] = (int) 1e8;
            }
            for (int i = 0; i < k; i++) {
                int next = in.ni();
                int left = next - 1, right = next - 1;
                for (int s = 1; ; s++) {
                    if (left < 0 && right >= n) break;
                    if (left >= 0) {
                        time[left] = Math.min(time[left], s);
                    }
                    if (right < n) {
                        time[right] = Math.min(time[right], s);
                    }
                    left--;
                    right++;
                }
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(time[i], max);
            }
            out.println(max);
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
        try (WaterTheGarden instance = new WaterTheGarden()) {
            instance.solve();
        }
    }
}
