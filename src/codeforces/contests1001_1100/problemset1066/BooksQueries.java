package codeforces.contests1001_1100.problemset1066;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class BooksQueries implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int q = in.ni(), offset = 200000;
        Map<Integer, Integer> indexOf = new HashMap<>();
        int left = offset, right = offset;
        for (int t = 0; t < q; t++) {
            char type = in.next().charAt(0);
            int idx = in.ni();
            if (t == 0) {
                indexOf.put(idx, left);
                left--;
                right++;
            } else {
                if (type == 'L') {
                    indexOf.put(idx, left);
                } else if (type == 'R') {
                    indexOf.put(idx, right);
                } else {
                    int index = indexOf.get(idx);
                    out.println(min(right - index, index - left) - 1);
                }
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
        try (BooksQueries instance = new BooksQueries()) {
            instance.solve();
        }
    }
}
