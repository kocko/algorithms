package hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaximumElement implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private Stack<Integer> stack = new Stack<>();
    private PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

    public void solve() {
        int n = in.ni();
        for (int i = 0; i < n; i++) {
            int command = in.ni();
            switch (command) {
                case 1:
                    int x = in.ni();
                    push(x);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    printMaximum();
                    break;
            }
        }
    }
    
    private void push(int n) {
        stack.push(n);
        queue.offer(n);
    }
    
    private void pop() {
        queue.remove(stack.pop());
    }
    
    private void printMaximum() {
        out.println(queue.peek());
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
        try (MaximumElement instance = new MaximumElement()) {
            instance.solve();
        }
    }
}
