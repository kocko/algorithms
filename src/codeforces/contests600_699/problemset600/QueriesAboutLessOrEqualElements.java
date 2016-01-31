package codeforces.contests600_699.problemset600;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class QueriesAboutLessOrEqualElements implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    List<Integer> a;

    public void solve() {
        int n = in.ni(), m = in.ni();
        a = new ArrayList<>(n);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            a.add(next);
            if (next > max) max = next;
            if (next < min) min = next;
        }
        Collections.sort(a);
        for (int i = 0; i < m; i++) {
            int b = in.ni();
            int count;
            if (b < min) {
                count = 0;
            } else if (b >= max) {
                count = n;
            } else {
                count = binary(b);
            }
            out.print(count + " ");
        }
        out.println();
    }

    int binary(int b) {
        int left = 0;
        int right = a.size() - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (a.get(mid) > b) {
                right = mid;
            } else {
                left = mid;
            }
        }
        while (left < a.size() && a.get(left) <= b) {
            left++;
        }
        return left;
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
        new QueriesAboutLessOrEqualElements().solve();
    }
}
