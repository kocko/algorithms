package codeforces.contests401_500.problemset493;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class VasyaAndWrestling implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long a = 0, b = 0;
        long x = 0;
        List<Long> f = new ArrayList<>();
        List<Long> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x = in.nl();
            if (x > 0) {
                a += x;
                f.add(x);
            }
            else {
                b -= x;
                s.add(-x);
            }
        }
        if (a == b) {
            int min = Math.min(f.size(), s.size());
            for (int i = 0; i < min; i++) {
                if (f.get(i) > s.get(i)) {
                    out.println("first");
                    return;
                }
                if (f.get(i) < s.get(i)) {
                    out.println("second");
                    return;
                }
            }
            out.println(x > 0 ? "first" : "second");
        } else {
            out.println(a > b ? "first" : "second");
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
        try (VasyaAndWrestling instance = new VasyaAndWrestling()) {
            instance.solve();
        }
    }
}
