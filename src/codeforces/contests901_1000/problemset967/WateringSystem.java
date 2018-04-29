package codeforces.contests901_1000.problemset967;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.util.Comparator.reverseOrder;

public class WateringSystem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), a = in.nl(), b = in.nl();
        PriorityQueue<Long> holes = new PriorityQueue<>(reverseOrder());
        long first = in.nl(), total = first;
        for (int i = 1; i < n; i++) {
            long next = in.nl();
            holes.offer(next);
            total += next;
        }
        if (first * a >= total * b) {
            out.println(0);
            return;
        }
        long S = holes.poll();
        int count = 1;
        while (first * a < (total - S) * b) {
            S += holes.poll();
            count++;
            if (holes.size() == 0) break;
        }
        out.println(count);
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
        try (WateringSystem instance = new WateringSystem()) {
            instance.solve();
        }
    }
}
