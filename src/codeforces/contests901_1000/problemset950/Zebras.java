package codeforces.contests901_1000.problemset950;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.util.Collections.singletonList;

public class Zebras implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        TreeSet<Integer> zeroes = new TreeSet<>(), ones = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (x[i] == '0') zeroes.add(i);
            else ones.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean ok;
        out: while (true) {
            List<Integer> zebra = new ArrayList<>();
            if (zeroes.size() == 0) {
                ok = (ones.size() == 0);
                break;
            }
            Integer first = zeroes.first();
            zebra.add(first);
            zeroes.remove(first);
            while (true) {
                Integer one = ones.ceiling(first);
                if (one == null) break;
                Integer next = zeroes.ceiling(one);
                if (next == null) {
                    ok = false;
                    break out;
                } else {
                    zebra.add(one);
                    zebra.add(next);
                    ones.remove(one);
                    zeroes.remove(next);
                    first = next;
                }
            }
            result.add(zebra);
        }
        if (!ok) {
            out.println(-1);
            return;
        }
        out.println(result.size());
        for (List<Integer> entry : result) {
            out.print(entry.size());
            out.print(' ');
            for (int i : entry) {
                out.print(i + 1);
                out.print(' ');
            }
            out.println();
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
        try (Zebras instance = new Zebras()) {
            instance.solve();
        }
    }
}
