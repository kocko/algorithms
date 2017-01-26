package hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class EqualStacks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Container implements Comparable<Container> {
        private ArrayDeque<Integer> deque;
        private int total;
        
        private Container(ArrayDeque<Integer> deque, int total) {
            this.deque = deque;
            this.total = total;
        }
        
        private void pop() {
            Integer top = deque.pollFirst();
            total -= top;
        }

        @Override
        public int compareTo(Container o) {
            return Integer.compare(this.total, o.total);
        }
    }

    public void solve() {
        int n1 = in.ni(), n2 = in.ni(), n3 = in.ni();
        List<Container> list = new ArrayList<>();
        list.add(readStack(n1));
        list.add(readStack(n2));
        list.add(readStack(n3));
        Collections.sort(list);
        int result = 0;
        while (list.get(0).total != list.get(2).total) {
            list.get(2).pop();
            Collections.sort(list);
        }
        out.println(list.get(0).total);
    }
    
    private Container readStack(int n) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            deque.add(next);
            total += next;
        }
        return new Container(deque, total);
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
        try (EqualStacks instance = new EqualStacks()) {
            instance.solve();
        }
    }
}
