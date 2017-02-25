package codeforces.contests701_800.problemset767;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Snacktower implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.ni();
        }
        int need = n;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            queue.offer(s[i]);
            int top = queue.peek();
            while (top == need) {
                need--;
                out.print(queue.poll() + " ");
                if (!queue.isEmpty()) {
                    top = queue.peek();
                } else break;
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
        try (Snacktower instance = new Snacktower()) {
            instance.solve();
        }
    }
}
