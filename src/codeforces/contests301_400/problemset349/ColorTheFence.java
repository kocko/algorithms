package codeforces.contests301_400.problemset349;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ColorTheFence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int v = in.ni();
        int[] x = new int[10];
        boolean can = false;
        for (int i = 1; i <= 9; i++) {
            x[i] = in.ni();
            if (x[i] <= v) can = true;
        }
        if (!can) {
            out.println(-1);
            return;
        }
        StringBuilder result = new StringBuilder();
        int total = 0;
        while (total <= v) {
            int digit = -1, cost = (int) 1e8;
            for (int i = 9; i >= 1; i--) {
                if (x[i] + total <= v && x[i] < cost) {
                    cost = x[i];
                    digit = i;
                }
            }
            if (digit == -1) {
                if (result.length() == 0) {
                    out.println(digit);
                    return;
                } else break;
            } else {
                result.append(digit);
                total += cost;
            }
        }
        char[] res = result.toString().toCharArray();
        for (int i = 0; i < res.length; i++) {
            int newCost = total - x[res[i] - '0'];
            for (int j = 9; j > 0; j--) {
                if (newCost + x[j] <= v) {
                    res[i] = (char) ('0' + j);
                    total = newCost + x[j];
                    break;
                }
            }
        }
        for (char c : res) {
            out.print(c);
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
        try (ColorTheFence instance = new ColorTheFence()) {
            instance.solve();
        }
    }
}
