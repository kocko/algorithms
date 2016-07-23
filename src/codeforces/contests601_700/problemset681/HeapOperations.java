package codeforces.contests601_700.problemset681;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HeapOperations implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (n-- > 0) {
            String operation = in.next();
            if ("insert".equals(operation)) {
                int value = in.ni();
                sb.append("insert ").append(value).append("\n");
                q.add(value);
                count++;
            } else if ("getMin".equals(operation)) {
                int value = in.ni();
                while (!q.isEmpty() && q.peek() < value) {
                    q.poll();
                    sb.append("removeMin").append("\n");
                    count++;
                }
                if (q.isEmpty() || q.peek() != value) {
                    sb.append("insert ").append(value).append("\n");
                    q.add(value);
                    count++;
                }
                sb.append("getMin ").append(value).append("\n");
                count++;
            } else {
                if (q.isEmpty()) {
                    sb.append("insert 0").append("\n");
                    count++;
                } else {
                    q.poll();
                }
                sb.append("removeMin").append("\n");
                count++;
            }
        }
        out.println(count);
        out.println(sb);
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
        try (HeapOperations instance = new HeapOperations()) {
            instance.solve();
        }
    }
}
