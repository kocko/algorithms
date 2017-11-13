package codeforces.contests001_100.problemset053;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlogPhoto implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long h = in.nl(), w = in.nl();
        long largestArea = 0, maxH = 0, maxW = 0;
        for (long i = 1L; i <= h; i <<= 1) {
            double from = (i * 4) / 5.0, to = (5 * i) / 4.0;
            long max = Math.min(w, (int) to);
            if (max >= from) {
                long area = max * i;
                if (area > largestArea) {
                    maxH = i;
                    maxW = max;
                    largestArea = area;
                } else if (area == largestArea) {
                    if (i > maxH) {
                        maxH = i;
                        maxW = max;
                    }
                }
            }
        }
        for (long i = 1L; i <= w; i <<= 1) {
            double from = (i * 4) / 5.0, to = (5 * i) / 4.0;
            long max = Math.min(h, (int) to);
            if (max >= from) {
                long area = max * i;
                if (area > largestArea) {
                    maxH = max;
                    maxW = i;
                } else if (area == largestArea) {
                    if (max > maxH) {
                        maxH = max;
                        maxW = i;
                    }
                }
            }
        }
        out.println(maxH + " " + maxW);
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
        try (BlogPhoto instance = new BlogPhoto()) {
            instance.solve();
        }
    }
}
