package codeforces.contests901_1000.problemset916;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JamieAndBinarySequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), k = in.ni();
        int bitCount = Long.bitCount(n);
        PriorityQueue<Integer> result = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i <= 60; i++) {
            if ((n & (1L << i)) != 0) {
                result.add(i + 1);
            }
        }
        if (bitCount == k) {
            out.println("Yes");
            while (!result.isEmpty()) {
                out.print(result.poll() - 1);
                out.print(' ');
            }
        } else if (bitCount < k) {
            while (bitCount < k) {
                int top = result.poll();
                result.offer(top - 1);
                result.offer(top - 1);
                bitCount++;
            }
            out.println("Yes");
            while (!result.isEmpty()) {
                out.print(result.poll() - 1);
                out.print(' ');
            }
        } else {
            out.println("No");
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
        try (JamieAndBinarySequence instance = new JamieAndBinarySequence()) {
            instance.solve();
        }
    }
}
