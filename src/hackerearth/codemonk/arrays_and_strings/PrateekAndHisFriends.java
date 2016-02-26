package hackerearth.codemonk.arrays_and_strings;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PrateekAndHisFriends implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(); long x = in.nl();
            long[] f = new long[n];
            for (int i = 0; i < n; i++) {
                f[i] = in.nl();
            }
            out.println(findContiguosGroup(x, f));
        }
    }

    String findContiguosGroup(long x, long[] f) {
        String result = "NO";
        long[] prefix = new long[f.length];
        prefix[0] = f[0];
        for (int i = 1; i < f.length; i++) {
             prefix[i] = prefix[i - 1] + f[i];
        }
        for (int i = 1; i < f.length; i++) {
            if (prefix[i] == x) return "YES";
            if (prefix[i] > x) {
                int left = 0, right = i - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (prefix[i] - prefix[mid] == x) return "YES";
                    else if (prefix[i] - prefix[mid] < x) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return result;
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
        new PrateekAndHisFriends().solve();
    }
}
