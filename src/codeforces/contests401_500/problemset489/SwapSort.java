package codeforces.contests401_500.problemset489;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class SwapSort implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        for (int i = 0; i < n; i++) {
            int j = i;
            for (int t = i; t < n; t++) {
                if (x[j] > x[t]) {
                    j = t;
                }
            }
            if (i != j) {
                result.add(new int[]{i, j});
            }
            x[i] = (x[i] ^ x[j]) ^ (x[j] = x[i]);
        }
        out.println(result.size());
        for (int[] swap : result) {
            out.println(swap[0] + " " + swap[1]);
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
        try (SwapSort instance = new SwapSort()) {
            instance.solve();
        }
    }
}
