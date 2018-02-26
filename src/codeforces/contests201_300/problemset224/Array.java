package codeforces.contests201_300.problemset224;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Array implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        Map<Integer, Integer> has = new HashMap<>();
        int left = -1, right = -1, i = 0, j = 0;
        while (j < n) {
            int next = x[j];
            if (has.size() < k) {
                int count = has.getOrDefault(next, 0);
                has.put(next, count + 1);
                j++;
            }
            while (has.size() == k) {
                left = i + 1;
                right = j;
                int first = x[i];
                int count = has.get(first);
                if (count > 1) {
                    has.put(first, count - 1);
                } else {
                    has.remove(first);
                }
                i++;
            }
        }
        if (left == -1 && right == -1) {
            if (has.size() == k) {
                left = 1;
                right = n;
            }
        }
        out.println(left + " " + right);
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
        try (Array instance = new Array()) {
            instance.solve();
        }
    }
}
