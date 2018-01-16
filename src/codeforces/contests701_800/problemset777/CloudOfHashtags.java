package codeforces.contests701_800.problemset777;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class CloudOfHashtags implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        String[] x = new String[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.next();
        }
        for (int i = n - 2; i >= 0; i--) {
            if (x[i].compareTo(x[i + 1]) > 0) {
                if (x[i].length() > x[i + 1].length()) {
                    x[i] = x[i].substring(0, x[i + 1].length());
                }
                for (int j = 0; j < x[i].length(); j++) {
                    if (x[i].charAt(j) != x[i + 1].charAt(j)) {
                        x[i] = x[i].substring(0, j);
                    }
                }
            }
        }
        for (String s : x) {
            out.println(s);
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
        try (CloudOfHashtags instance = new CloudOfHashtags()) {
            instance.solve();
        }
    }
}
