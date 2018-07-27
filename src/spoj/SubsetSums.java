package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Math.min;
import static java.util.Comparator.naturalOrder;

public class SubsetSums implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), a = in.ni(), b = in.ni();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.ni();
        }
        List<Integer> left = new ArrayList<>();
        int bits = n / 2;
        int limit = (1 << bits) - 1;
        for (int mask = 0; mask <= limit; mask++) {
            int sum = 0;
            for (int bit = 0; bit < bits; bit++) {
                if ((mask & (1 << bit)) != 0) {
                    sum += s[bit];
                }
            }
            left.add(sum);
        }
        left.sort(naturalOrder());

        bits = n - bits;
        limit = (1 << bits) - 1;
        long result = 0;

        for (int mask = 0; mask <= limit; mask++) {
            int sum = 0;
            for (int bit = 0; bit < bits; bit++) {
                if ((mask & (1 << bit)) != 0) {
                    sum += s[n / 2 + bit];
                }
            }
            int start = left.size() + 1, end = -1;
            int lo = 0, hi = left.size() - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (sum + left.get(mid) >= a) {
                    start = min(start, mid);
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            lo = 0;
            hi = left.size() - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (sum + left.get(mid) <= b) {
                    end = max(start, mid);
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            if (start != left.size() + 1 && end != -1) {
                result += (end - start + 1);
            }
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
        try (SubsetSums instance = new SubsetSums()) {
            instance.solve();
        }
    }
}
