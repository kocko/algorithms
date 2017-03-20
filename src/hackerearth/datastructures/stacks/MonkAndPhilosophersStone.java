package hackerearth.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class MonkAndPhilosophersStone implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class MonkStack extends Stack<Integer> {
        private int total;

        @Override
        public synchronized boolean add(Integer value) {
            total += value;
            return super.add(value);
        }

        @Override
        public synchronized Integer pop() {
            int value = super.pop();
            total -= value;
            return value;
        }
        
        private synchronized int getTotal() {
            return total;
        }
    }

    public void solve() {
        int n = in.ni();
        int[] bag = new int[n];
        for (int i = 0; i < n; i++) {
            bag[i] = in.ni();
        }
        int q = in.ni(), target = in.ni();
        MonkStack monkStack = new MonkStack();
        int idx = 0;
        while (q-- > 0) {
            boolean harry = "Harry".equals(in.next());
            if (harry) {
                monkStack.add(bag[idx++]);
            } else {
                if (!monkStack.isEmpty()) {
                    monkStack.pop();
                }
            }
            if (monkStack.getTotal() == target) {
                out.println(monkStack.size());
                return;
            }
        }
        out.println(-1);
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
        try (MonkAndPhilosophersStone instance = new MonkAndPhilosophersStone()) {
            instance.solve();
        }
    }
}
