package codeforces.contests1001_1100.problemset1082;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class VovaAndTrophies implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        int g = 0, s = 0, result = 0;
        int[] group = new int[n];
        List<Integer> sizes = new ArrayList<>();
        int idx = 0, current = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] == 'G') {
                g++;
                current++;
                group[i] = idx;
            } else {
                sizes.add(current);
                result = Math.max(result, current);
                current = 0;
                idx++;
                s++;
            }
        }
        if (current > 0) {
            sizes.add(current);
        }
        if (g == n) {
            out.println(n);
        } else if (s == n) {
            out.println(0);
        } else {
            int groups = sizes.size();
            for (int i = 1; i < n - 1; i++) {
                if (x[i - 1] == 'G' && x[i] == 'S' && x[i + 1] == 'G') {
                    if (groups > 2) {
                        result = Math.max(result, sizes.get(group[i - 1]) + sizes.get(group[i + 1]) + 1);
                    } else if (groups == 2) {
                        result = Math.max(result, Math.max(sizes.get(0), sizes.get(1)) + 1);
                    }
                } else if (x[i - 1] == 'G' && x[i] == 'S') {
                    if (groups > 1) {
                        result = Math.max(result, sizes.get(group[i - 1]) + 1);
                    }
                }
            }
            out.println(result);
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
        try (VovaAndTrophies instance = new VovaAndTrophies()) {
            instance.solve();
        }
    }
}
