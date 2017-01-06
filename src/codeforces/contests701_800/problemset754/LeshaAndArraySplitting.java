package codeforces.contests701_800.problemset754;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LeshaAndArraySplitting implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        boolean allAreZeroes = true;
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            allAreZeroes &= (x[i] == 0);
        }
        if (allAreZeroes) {
            out.println("NO");
        } else {
            out.println("YES");
            List<int[]> lists = new ArrayList<>();
            int[] k = new int[2];
            int left = 1, right = 1;
            for (int i = 0; i < n; i++) {
                if (x[i] == 0) {
                    right++;
                } else {
                    k[0] = left;
                    k[1] = right;
                    lists.add(k);
                    k = new int[2];
                    left = right + 1;
                    right = right + 1;
                }
            }
            out.println(lists.size());
            for (int[] t : lists) {
                out.println(t[0] + " " + t[1]);
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
        try (LeshaAndArraySplitting instance = new LeshaAndArraySplitting()) {
            instance.solve();
        }
    }
}
