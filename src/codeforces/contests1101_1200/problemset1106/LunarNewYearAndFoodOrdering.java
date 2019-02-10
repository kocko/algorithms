package codeforces.contests1101_1200.problemset1106;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.util.Comparator.comparingLong;

public class LunarNewYearAndFoodOrdering implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        long[] a = new long[n], c = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nl();
        for (int i = 0; i < n; i++) c[i] = in.nl();

        TreeMap<Integer, Long> tree = new TreeMap<>(comparingLong((Integer o) -> c[o]).thenComparingInt(o -> o));
        for (int i = 0; i < n; i++) {
            tree.put(i, c[i]);
        }

        for (int i = 0; i < m; i++) {
            int type = in.ni() - 1, dishes = in.ni();
            long cost = 0;
            boolean angry = false;
            while (dishes > 0) {
                if (a[type] >= dishes) {
                    a[type] -= dishes;
                    cost += dishes * c[type];
                    if (a[type] == 0) {
                        tree.remove(type);
                    }
                    dishes = 0;
                } else if (a[type] > 0) {
                    cost += a[type] * c[type];
                    dishes -= a[type];
                    a[type] = 0;
                    tree.remove(type);
                } else {
                    if (tree.size() == 0) {
                        angry = true;
                        break;
                    } else {
                        int first = tree.firstKey();
                        long count = a[first];
                        if (count >= dishes) {
                            a[first] -= dishes;
                            cost += c[first] * dishes;
                            dishes = 0;
                            if (a[first] == 0) {
                                tree.remove(first);
                            }
                        } else {
                            a[first] -= dishes;
                            tree.remove(first);
                            cost += c[first] * count;
                            dishes -= count;
                        }
                    }
                }
            }
            out.println(angry ? 0 : cost);
        }
    }

    private class Dish implements Comparable<Dish> {
        private int idx;
        private long price;

        private Dish(int idx, long price) {
            this.idx = idx;
            this.price = price;
        }

        @Override
        public int compareTo(Dish o) {
            Integer x = Long.compare(this.price, o.price);
            return x != 0 ? x : Integer.compare(this.idx, o.idx);
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
        try (LunarNewYearAndFoodOrdering instance = new LunarNewYearAndFoodOrdering()) {
            instance.solve();
        }
    }
}
