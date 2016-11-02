package hackerrank.datastructures.heaps;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FindTheRunningMedian implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final DecimalFormat format = new DecimalFormat("#.0");
    
    public void solve() {
        int n = in.ni();
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> right = new PriorityQueue<>();
        left.add(in.ni());
        print(left.peek());
        for (int i = 1; i < n; i++) {
            int next = in.ni();
            if (i % 2 == 0) {
                if (next >= right.peek()) {
                    left.add(right.poll());
                    right.add(next);
                } else {
                    left.add(next);
                }
                print(left.peek());
            } else {
                if (left.peek() <= next) {
                    right.add(next);
                } else {
                    right.add(left.poll());
                    left.add(next);
                }
                print((left.peek() + right.peek()) / 2.0);
            }
        }
    }
    
    private void print(double value) {
        out.println(format.format(value));
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
        try (FindTheRunningMedian instance = new FindTheRunningMedian()) {
            instance.solve();
        }
    }
}
