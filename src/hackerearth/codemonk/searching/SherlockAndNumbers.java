package hackerearth.codemonk.searching;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SherlockAndNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), k = in.ni(), p = in.ni();
            int[] prefix = new int[k];
            int[] a = new int[k];
            a[0] = in.ni();
            prefix[0] = a[0] - 1;
            for (int i = 1; i < k; i++) {
                a[i] = in.ni();
                prefix[i] = prefix[i - 1] + (a[i] - a[i - 1] - 1);
            }
            if (p <= n - k) {
                if (p >= prefix[0]) {
                    int x = findTheBiggestSmallerIndex(prefix, p);
                    out.println(p + x + 1);
                } else {
                    out.println(p);
                }
            } else {
                out.println(-1);
            }
        }
    }

    private int findTheBiggestSmallerIndex(int[] arr, int p) {
        int left = 0, right = arr.length - 1;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < p) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
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
        new SherlockAndNumbers().solve();
    }
}
