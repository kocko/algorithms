package codeforces.contests1101_1200.problemset1106;

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

public class LunarNewYearAndNumberDivision implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nl());
        }
        list.sort(Comparator.naturalOrder());
        long result = 0;
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                long s = list.get(i) + list.get(n - i - 1);
                result += (s * s);
            }
        } else {
            for (int i = 0; i < n / 2 - 1; i++) {
                long s = list.get(i) + list.get(n - i - 1);
                result += (s * s);
            }
            long s = list.get(n / 2 - 1) + list.get(n / 2) + list.get(n / 2 + 1);
            result += s * s;
        }
        out.println(result);
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
        try (LunarNewYearAndNumberDivision instance = new LunarNewYearAndNumberDivision()) {
            instance.solve();
        }
    }
}
