package codeforces.contests1001_1100.problemset1027;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Comparator.naturalOrder;

public class MinimumValueRectangle implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            List<Integer> list = new ArrayList<>(), pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(in.ni());
            }
            list.sort(naturalOrder());
            for (int i = 1; i < n;) {
                if (list.get(i).equals(list.get(i - 1))) {
                    pairs.add(list.get(i));
                    i += 2;
                } else i++;
            }
            double min = (pairs.get(1) * 1.) / pairs.get(0);
            int[] best = {pairs.get(0), pairs.get(1)};
            for (int i = 2; i < pairs.size() ; i++) {
                double ratio = (pairs.get(i) * 1.)/ pairs.get(i - 1);
                if (ratio < min) {
                    min = ratio;
                    best[0] = pairs.get(i - 1);
                    best[1] = pairs.get(i);
                }
            }
            out.printf("%d %d %d %d\n", best[0], best[0], best[1], best[1]);
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
        try (MinimumValueRectangle instance = new MinimumValueRectangle()) {
            instance.solve();
        }
    }
}
