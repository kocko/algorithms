package codeforces.contests901_1000.problemset988;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class PointsAndPowersOfTwo implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            list.add(next);
            set.add(next);
        }
        sort(list);
        int[] best = new int[]{list.get(n - 1)}; 
        for (int power = 0; power <= 30; power++) {
            int d = 1 << power;
            for (int i = 1; i < n; i++) {
                boolean a = set.contains(list.get(i) - d);
                boolean b = set.contains(list.get(i) + d);
                if (a && b) {
                    out.println(3);
                    out.print(list.get(i) - d);
                    out.print(' ');
                    out.print(list.get(i));
                    out.print(' ');
                    out.print(list.get(i) + d);
                    return;
                } else if (a) {
                    best = new int[] {list.get(i), list.get(i) - d};
                } else if (b) {
                    best = new int[] {list.get(i), list.get(i) + d};
                }
            }
        }
        out.println(best.length);
        for (int x : best) {
            out.print(x);
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
        try (PointsAndPowersOfTwo instance = new PointsAndPowersOfTwo()) {
            instance.solve();
        }
    }
}
