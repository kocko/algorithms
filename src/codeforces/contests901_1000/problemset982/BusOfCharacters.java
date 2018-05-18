package codeforces.contests901_1000.problemset982;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class BusOfCharacters implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = in.ni();
        }
        char[] x = in.next().toCharArray();
        PriorityQueue<Integer> allEmpty = new PriorityQueue<>(Comparator.comparingInt(a -> w[a]));
        PriorityQueue<Integer> oneSeat = new PriorityQueue<>(Comparator.comparingInt(a -> -w[a]));
        for (int i = 1; i <= n; i++) {
            allEmpty.offer(i);
        }
        for (int i = 0; i < 2 * n; i++) {
            int row;
            if (x[i] == '0') {
                row = allEmpty.poll();
                oneSeat.offer(row);
            } else {
                row = oneSeat.poll();
            }
            out.print(row);
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
        try (BusOfCharacters instance = new BusOfCharacters()) {
            instance.solve();
        }
    }
}
