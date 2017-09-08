package codeforces.contests401_500.problemset401;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Team implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int zeroes = in.ni(), ones = in.ni();
        if (ones > 2 * zeroes + 2 || zeroes > ones + 1) {
            out.println(-1);
            return;
        }
        StringBuilder[] result = new StringBuilder[zeroes];
        for (int i = 0; i < zeroes; i++) {
            result[i] = new StringBuilder("0");
        }
        if (ones > 2 * zeroes) {
            result[0] = result[0].append('1').reverse();
            ones--;
        }
        if (ones > 2 * zeroes) {
            result[zeroes - 1].append('1');
            ones--;
        }
        int next = 0;
        while (ones > 0) {
            if (next < zeroes) {
                result[next].append('1');
            } else {
                result[next % zeroes] = result[next % zeroes].reverse().append('1').reverse();
            }
            ones--;
            next++;
        }
        for (StringBuilder sb : result) {
            out.print(sb);
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
        try (Team instance = new Team()) {
            instance.solve();
        }
    }
}
