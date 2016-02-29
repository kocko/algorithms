package codeforces.contests301_400.problemset327;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FlippingGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[] list = new int[n];
        list[0] = in.ni();
        for (int i = 1; i < n; i++) {
            list[i] = in.ni();
        }
        out.println(kadane(list));
    }

    private int kadane(int[] list) {
        int ones = 0;
        int result = 0, sum = 0;
        for (int i : list) {
            ones += i;
            if (i == 0) {
                result = Math.max(result, ++sum);
            } else if (--sum < 0) {
                sum = 0;
            }
        }
        if (ones == list.length) {
            result = -1;
        }
        return ones + result;
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
        new FlippingGame().solve();
    }
}
