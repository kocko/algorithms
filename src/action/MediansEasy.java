package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.util.Comparator.reverseOrder;

public class MediansEasy implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        PriorityQueue<Integer> left = new PriorityQueue<>(reverseOrder()), right = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            int next = in.ni();
            left.add(next);
            if (left.size() - right.size() >= 2 || (right.size() > 0 && left.peek() > right.peek())) {
                right.offer(left.poll());
            }
            if (right.size() > left.size()) {
                left.offer(right.poll());
            }
            double median;
            if (i % 2 == 0) {
                median = (left.peek() + right.peek()) / 2.;
            } else {
                median = (double) left.peek();
            }
            out.print(median);
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
        try (MediansEasy instance = new MediansEasy()) {
            instance.solve();
        }
    }
}
