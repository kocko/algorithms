package hackerrank.datastructures.heaps;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class QHEAP1 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    int[] heap;
    int index;

    public void solve() {
        int n = in.ni();
        heap = new int[n];
        for (int i = 0; i < n; i++) {
            int command = in.ni();
            switch(command) {
                case 1: {
                    save(in.ni());
                    break;
                }
                case 2: {
                    delete(in.ni());
                    break;
                }
                case 3: {
                    printTop();
                    break;
                }
                default: throw new IllegalArgumentException("Invalid command");
            }
        }
    }

    private void save(int value) {
        heap[index] = value;
        int childIndex = index;
        while (childIndex > 0) {
            int parentIndex = index / 2 - index % 2;
            if (heap[childIndex] < heap[parentIndex]) {
                int temp = heap[parentIndex];
                heap[parentIndex] = heap[childIndex];
                heap[childIndex] = temp;
            }
        }
        index++;
    }

    private void delete(int value) {

    }

    private void printTop() {
        out.println(heap[0]);
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

    public static void main(String[] args) {
        new QHEAP1().solve();
    }
}
