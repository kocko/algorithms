package codeforces.contests201_300.problemset270;

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
import static java.util.Comparator.reverseOrder;

public class MagicalBoxes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Box implements Comparable<Box> {
        private long size, count;

        private Box(long size, long count) {
            this.size = size;
            this.count = count;
        }

        @Override
        public int compareTo(Box o) {
            return Long.compare(size, o.size);
        }
    }

    public void solve() {
        int n = in.ni();
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxes.add(new Box(in.nl(), in.nl()));
        }
        boxes.sort(reverseOrder());
        long result = 0;
        for (Box box : boxes) {
            long count = box.count, size = box.size;
            long boxesPerRow = (long) sqrt(count);
            if (boxesPerRow * boxesPerRow < count) {
                boxesPerRow++;
            }
            long total = calculateSize(boxesPerRow) + size;
            if (total > result) {
                result = total;
            }
        }
        if (result == boxes.get(0).size) {
            result++;
        }
        out.println(result);
    }
    
    private int calculateSize(long n) {
        int result = 0;
        for (int i = 0; i <= 60; i++) {
            if ((n & (1L << i)) != 0) {
                result = i;
            }
        }
        if ((1L << result) < n) {
            result++;
        }
        return result;
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
        try (MagicalBoxes instance = new MagicalBoxes()) {
            instance.solve();
        }
    }
}
