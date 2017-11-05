package codeforces.contests201_300.problemset225;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WellKnownNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int s = in.ni(), k = in.ni();
        List<Long> list = new ArrayList<>();
        if (k > 30) {
            for (int i = 0; i < 30; i++) {
                list.add(1L << i);
            }
        } else {
            for (int i = 0; i < k - 1; i++) {
                list.add(0L);
            }
            list.add(1L);
            list.add(1L);
            for (int i = list.size(); ; i++) {
                long x = 2 * list.get(i - 1) - list.get(i - k - 1);
                if (x > s) break;
                list.add(x);
            }
        }
        List<Long> result = new ArrayList<>();
        result.add(0L);
        for (int i = list.size() - 1; i >= 0; i--) {
            long value = list.get(i);
            if (value <= s) {
                result.add(value);
                s -= value;
            }
            if (s == 0) break;
        }
        out.println(result.size());
        for (Long value : result) {
            out.print(value);
            out.print(' ');
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
        try (WellKnownNumbers instance = new WellKnownNumbers()) {
            instance.solve();
        }
    }
}
