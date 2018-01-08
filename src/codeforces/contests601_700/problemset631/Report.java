package codeforces.contests601_700.problemset631;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;

public class Report implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Operation {
        private int type, idx;

        private Operation(int type, int idx) {
            this.type = type;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return idx + "";
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.ni();
        ArrayDeque<Operation> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            int type = in.ni(), idx = in.ni();
            Operation op = new Operation(type, idx);
            while (!deque.isEmpty() && deque.peekLast().idx <= idx) {
                deque.pollLast();
            }
            deque.offerLast(op);
        }
        int max = deque.peekFirst().idx;
        int[] b = new int[max];
        arraycopy(a, 0, b, 0, max);
        sort(b);
        deque.add(new Operation(0, 0));
        int left = 0, right = max - 1;
        while (deque.size() > 1) {
            Operation current = deque.pollFirst(), next = deque.peekFirst();
            if (current.type == 2) {
                for (int idx = current.idx - 1; idx > next.idx - 1; idx--) {
                    a[idx] = b[left++];
                }
            } else {
                for (int idx = current.idx - 1; idx > next.idx - 1; idx--) {
                    a[idx] = b[right--];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(a[i]);
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
        try (Report instance = new Report()) {
            instance.solve();
        }
    }
}
