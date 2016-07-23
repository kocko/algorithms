package codeforces.contests501_600.problemset581;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LuxuriousHouses implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = in.ni();
        }
        int[] result = new int[n];
        int max = houses[n - 1];
        result[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (houses[i] <= max) {
                result[i] = max - houses[i] + 1;
            } else {
                max = houses[i];
                result[i] = 0;
            }
        }
        for (int i : result) {
            out.print(i + " ");
        }
        out.println();
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
        new LuxuriousHouses().solve();
    }
}
