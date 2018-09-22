package codeforces.contests1001_1100.problemset1046;

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
import static java.util.Comparator.reverseOrder;

public class SpaceFormula implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), d = in.ni();
        int[] points = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            points[i] = in.ni();
        }
        int[] awards = new int[n + 1];
        for (int i = 0; i < n; i++) {
            awards[i + 1] = in.ni();
        }
        int pos = 1;
        points[d] += awards[1];
        PriorityQueue<Integer> less = new PriorityQueue<>(reverseOrder());
        for (int i = 1; i <= d - 1; i++) {
            if (points[i] <= points[d]) {
                less.add(points[i]);
            } else {
                pos++;
            }
        }
        int idx = n;
        while (!less.isEmpty()) {
            int top = less.poll();
            if (top + awards[idx--] > points[d]) {
                pos++;
            }
        }
        
        out.println(pos);
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
        try (SpaceFormula instance = new SpaceFormula()) {
            instance.solve();
        }
    }
}
