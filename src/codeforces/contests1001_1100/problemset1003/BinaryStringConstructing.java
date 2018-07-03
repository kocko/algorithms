package codeforces.contests1001_1100.problemset1003;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BinaryStringConstructing implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b = in.ni(), x = in.ni();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(0);
        a--; b--; x--;
        boolean reverse = true;
        while (x > 0) {
            if (x == 1) {
                if (a > 0) {
                    if (deque.peekLast() == 1) {
                        deque.addLast(0);
                    } else {
                        deque.addFirst(0);
                    }
                    a--;
                } else {
                    if (deque.peekLast() == 0) {
                        deque.addLast(1);
                    } else {
                        deque.addFirst(1);
                    }
                    b--;
                }
                x--;
            } else {
                if (reverse) {
                    deque.addLast(1);
                    deque.addFirst(0);
                } else {
                    deque.addLast(0);
                    deque.addFirst(1);
                }
                reverse = !reverse;
                x -= 2;
                a--;
                b--;
            }
        }
        for (int i = 0; i < a; i++) {
            if (deque.peekLast() == 0) deque.addLast(0);
            else deque.addFirst(0);
        }
        for (int i = 0; i < b; i++) {
            if (deque.peekLast() == 1) deque.addLast(1);
            else deque.addFirst(1);
        }
        while (!deque.isEmpty()) out.print(deque.pollFirst());
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
        try (BinaryStringConstructing instance = new BinaryStringConstructing()) {
            instance.solve();
        }
    }
}
