package uva.volume005;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Rails implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            if (n == 0) break;
            while (true) {
                String permutation = in.readLine();
                if ("0".equals(permutation)) {
                    out.println();
                    break;
                }
                String[] split = permutation.split("\\s+");
                int[] order = new int[n];
                for (int i = 0; i < n; i++) order[i] = Integer.parseInt(split[i]); 
                Stack<Integer> stack = new Stack<>();
                int next = 1;
                for (int i = 0; i < n; i++) {
                    int target = order[i];
                    while (stack.isEmpty() || stack.peek() < target) {
                        stack.add(next++);
                    }
                    if (stack.peek() == target) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                out.println(stack.empty() ? "Yes" : "No");
            }
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
        try (Rails instance = new Rails()) {
            instance.solve();
        }
    }
}
