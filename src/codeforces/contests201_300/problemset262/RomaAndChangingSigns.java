package codeforces.contests201_300.problemset262;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RomaAndChangingSigns implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = in.ni();
        }
        Arrays.sort(list);
        int i = 0, idx = 0;
        while (i < k && idx < n) {
            if (list[idx] < 0) {
                list[idx] *= -1;
                idx++;
                i++;
            } else {
                Arrays.sort(list);
                if ((k - i) % 2 == 1) {
                    list[0] *= -1;
                    i = k;
                }
                break;
            }
        }
        if ((k - i) % 2 == 1) {
            list[0] *= -1;
        }
        long sum = 0L;
        for (int x : list) {
            sum += x;
        }
        out.println(sum);
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
        try (RomaAndChangingSigns instance = new RomaAndChangingSigns()) {
            instance.solve();
        }
    }
}
