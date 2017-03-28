package uva.volume119;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class ICanGuessTheDataStructure implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);

    private final String[] MESSAGES = {
            "impossible",
            "priority queue", 
            "queue",
            "not sure",
            "stack",
            "not sure",
            "not sure",
            "not sure"
    };
    
    public void solve() throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            Stack<Integer> stack = new Stack<>();
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            int mask = 7;
            while (n-- > 0) {
                String[] split = in.readLine().split("\\s+");
                int value = Integer.parseInt(split[1]);
                switch (split[0]) {
                    case "1": {
                        stack.add(value);
                        queue.add(value);
                        priorityQueue.offer(value);
                        break;
                    }
                    case "2": {
                        if (!stack.empty()) {
                            mask = setBit(mask, 2, (stack.pop() == value ? 1 : 0));
                        } else {
                            mask = 0;
                        }
                        if (!queue.isEmpty()) {
                            mask = setBit(mask, 1, (queue.pollFirst() == value ? 1 : 0));
                        } else {
                            mask = 0;
                        }
                        if (!priorityQueue.isEmpty()) {
                            mask = setBit(mask, 0, (priorityQueue.poll() == value ? 1 : 0));
                        } else {
                            mask = 0;
                        }
                    }
                }
            }
            out.println(MESSAGES[mask]);
        }
    }
    
    private int setBit(int number, int n, int value) {
        if ((number & (1 << n)) != 0 && value == 0) {
            number &= ~(1 << n);
        }
        return number;
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
        try (ICanGuessTheDataStructure instance = new ICanGuessTheDataStructure()) {
            instance.solve();
        }
    }
}
