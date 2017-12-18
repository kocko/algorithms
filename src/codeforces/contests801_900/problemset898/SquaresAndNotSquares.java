package codeforces.contests801_900.problemset898;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;
import static java.util.Comparator.naturalOrder;

public class SquaresAndNotSquares implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Entry implements Comparable<Entry> {
        private long value;
        private long squareCost;
        private long nonSquareCost;

        private Entry(long value) {
            this.value = value;
            squareCost();
            nonSquareCost();
        }

        private void squareCost() {
            long root = (long) sqrt(value);
            long low = root * root;
            long high = (root + 1) * (root + 1);
            if (root * root == value) {
                squareCost = 0L;
            } else {
                squareCost = Math.min(value - low, high - value);
            }
        }

        private void nonSquareCost() {
            if (squareCost == 0) {
                nonSquareCost = value == 0 ? 2L : 1L;
            }
        }

        private long getSquareCost() {
            return squareCost;
        }

        private long getNonSquareCost() {
            return nonSquareCost;
        }

        @Override
        public int compareTo(Entry o) {
            int x = Long.compare(this.getSquareCost(), o.getSquareCost());
            return x != 0 ? x : Long.compare(o.getNonSquareCost(), this.getNonSquareCost());
        }
    }

    public void solve() {
        int n = in.ni(), squares = 0;
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long next = in.ni();
            Entry entry = new Entry(next);
            list.add(entry);
            if (entry.getSquareCost() == 0) squares++;
        }
        list.sort(naturalOrder());
        int half = n / 2;
        long result = 0L;
        if (squares > half) {
            for (int i = half; i < n; i++) {
                result += list.get(i).getNonSquareCost();
            }
        } else if (squares < half) {
            for (int i = 0; i < half; i++) {
                result += list.get(i).getSquareCost();
            }
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
        try (SquaresAndNotSquares instance = new SquaresAndNotSquares()) {
            instance.solve();
        }
    }
}
