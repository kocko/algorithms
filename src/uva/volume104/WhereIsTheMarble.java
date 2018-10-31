package uva.volume104;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class WhereIsTheMarble implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        final int oo = (int) 1e9;
        int n, q, testCase = 0;
        while ((n = in.ni()) != 0 | (q = in.ni()) != 0) {
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.ni();
            }
            Arrays.sort(x);
            out.printf("CASE# %d:\n", ++testCase);
            while (q-- > 0) {
                int value = in.ni();
                int left = 0, right = n - 1, result = oo;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (x[mid] > value) {
                        right = mid - 1;
                    } else if (x[mid] < value) {
                        left = mid + 1;
                    } else {
                        result = min(result, mid + 1);
                        right = mid - 1;
                    }
                }
                if (result == oo) {
                    out.printf("%d not found\n", value);
                } else {
                    out.printf("%d found at %d\n", value, result);
                }
            }
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
        try (WhereIsTheMarble instance = new WhereIsTheMarble()) {
            instance.solve();
        }
    }
}
