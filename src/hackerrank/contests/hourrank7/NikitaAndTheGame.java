package hackerrank.contests.hourrank7;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NikitaAndTheGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    long[] prefix;
    long[] list;

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            list = new long[n];
            prefix = new long[n];
            for (int i = 0; i < n; i++) {
                list[i] = in.nl();
                if (i == 0) {
                    prefix[i] = list[i];
                } else {
                    prefix[i] = list[i] + prefix[i - 1];
                }
            }
            int result = go(0, n - 1);
            out.println(result);
        }
    }

    private int go(int start, int end) {
        int splittingIndex = split(start, end);
        if (start < end && splittingIndex != -1) {
            return 1 + Math.max(go(start, splittingIndex), go(splittingIndex + 1, end));
        }
        return 0;
    }

    private int split(int start, int end) {
        int s = start, e = end;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (prefix[mid] < prefix[end] - prefix[mid]) {
                s = mid + 1;
            } else if (prefix[mid] > prefix[end] - prefix[mid]) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
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
        new NikitaAndTheGame().solve();
    }
}
