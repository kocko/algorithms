package hackerrank.datastructures.heaps;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JesseAndCookies implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (n-- > 0) {
            queue.add(in.ni());
        }
        if (queue.size() == 1) {
            if (queue.peek() >= k) {
                out.println(0);
            } else {
                out.println(-1);
            }
        } else {
            int result = 0;
            while (queue.peek() < k) {
                if (queue.size() <= 1) {
                    if (queue.peek() >= k) break;
                    else {
                        out.println(-1);
                        return;
                    }
                }
                int first = queue.poll();
                int second = queue.poll();
                queue.add(first + 2 * second);
                result++;
            }
            out.println(result);
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
        try (JesseAndCookies instance = new JesseAndCookies()) {
            instance.solve();
        }
    }
}
