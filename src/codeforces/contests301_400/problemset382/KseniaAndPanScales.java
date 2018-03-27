package codeforces.contests301_400.problemset382;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class KseniaAndPanScales implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        char[] add = in.next().toCharArray();
        StringBuilder left = new StringBuilder(), right = new StringBuilder();
        boolean isLeft = true;
        for (char c : x) {
            StringBuilder builder = isLeft ? left : right;
            if (c == '|') {
                isLeft = false;
            } else {
                builder.append(c);
            }
        }
        for (char c : add) {
            StringBuilder builder = left.length() <= right.length() ? left : right;
            builder.append(c);
        }
        if (left.length() == right.length()) {
            out.println(left + "|" + right);
        } else {
            out.println("Impossible");
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
        try (KseniaAndPanScales instance = new KseniaAndPanScales()) {
            instance.solve();
        }
    }
}
