package codeforces.contests501_600.problemset538;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class TouristsNotes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        m = in.ni();
        day = new int[m];
        height = new int[m];
        for (int i = 0; i < m; i++) {
            day[i] = in.ni();
            height[i] = in.ni();
        }
        if (!valid()) {
            out.println("IMPOSSIBLE");
            return;
        }
        int max = 0;
        int left = 0, right = (int) 1e9;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (can(mid)) {
                max = max(mid, max);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        out.println(max);
    }

    private int n, m;
    private int[] day, height;

    private boolean can(int max) {
        boolean can = height[0] + day[0] - 1 >= max;
        for (int i = 0; i < m - 1; i++) {
            int count = abs(height[i] - max) + abs(height[i + 1] - max);
            can |= count <= day[i + 1] - day[i];
        }
        can |= height[m - 1] + (n - day[m - 1]) >= max;
        return can;
    }

    private boolean valid() {
        for (int i = 0; i < m - 1; i++) {
            int diff = day[i + 1] - day[i];
            if (height[i] + diff < height[i + 1] || height[i] - diff > height[i + 1]) {
                return false;
            }
        }
        return true;
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
        try (TouristsNotes instance = new TouristsNotes()) {
            instance.solve();
        }
    }
}
