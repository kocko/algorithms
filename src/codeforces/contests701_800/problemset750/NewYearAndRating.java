package codeforces.contests701_800.problemset750;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewYearAndRating implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final int INF = 1000000001;
    private final int DIVISION = 1;
    private int[][] diff;
    
    public void solve() {
        int n = in.ni();
        diff = new int[n][2];
        for (int i = 0; i < n; i++) {
            diff[i][0] = in.ni();
            diff[i][1] = in.ni();
        }
        int left = -INF, right = INF;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int rating = good(mid);
            if (rating == INF) {
                left = mid + 1;
            } else if (rating == -INF) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left >= INF) {
            out.println("Infinity");
            return;
        } 
        int result = good(left - 1);
        if (result != INF && result != -INF) {
            out.println(result);
        } else {
            out.println("Impossible");
        }
    }
    
    private int good(int rating) {
        for (int[] contest : diff) {
            if (rating < 1900 && contest[1] == 1) {
                return INF;
            }
            if (rating >= 1900 && contest[1] == 2) {
                return -INF;
            }
            rating += contest[0];
        }
        return rating;
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
        try (NewYearAndRating instance = new NewYearAndRating()) {
            instance.solve();
        }
    }
}
