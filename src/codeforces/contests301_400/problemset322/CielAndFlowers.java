package codeforces.contests301_400.problemset322;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class CielAndFlowers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int r = in.ni(), g = in.ni(), b = in.ni();
        int[] temp = new int[3];
        temp[0] = r / 3 + g / 3 + b / 3;
        if (r >= 1 && g >= 1 && b >= 1) temp[1] = 1 + (r - 1) / 3 + (g - 1) / 3 + (b - 1) / 3;
        if (r >= 2 && g >= 2 && b >= 2) temp[2] = 2 + (r - 2) / 3 + (g - 2) / 3 + (b - 2) / 3;
        Arrays.sort(temp);
        out.println(temp[2]);
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
        try (CielAndFlowers instance = new CielAndFlowers()) {
            instance.solve();
        }
    }
}
