package codeforces.contests301_400.problemset342;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class XeniaAndSpies implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), s = in.ni(), f = in.ni(), step = s > f ? -1 : 1;
        char move = step == 1 ? 'R' : 'L';
        int[] time = new int[m], left = new int[m], right = new int[m];
        for (int i = 0; i < m; i++) {
            int t = in.ni(), l = in.ni(), r = in.ni();
            time[i] = t;
            left[i] = l;
            right[i] = r;
        }
        StringBuilder result = new StringBuilder();
        int idx = 0;
        for (int t = 1; ;t++) {
            if (idx == m) break;
            if (time[idx] == t) {
                if ((s >= left[idx] && s <= right[idx]) || 
                    (s + step >= left[idx] && s + step <= right[idx])) {
                    result.append('X');
                } else {
                    result.append(move);
                    s += step;
                }
                idx++;
            } else {
                s += step;
                result.append(move);
            }
            if (s == f) {
                break;
            }
        }
        while (s != f) {
            result.append(move);
            s += step;
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
        try (XeniaAndSpies instance = new XeniaAndSpies()) {
            instance.solve();
        }
    }
}
