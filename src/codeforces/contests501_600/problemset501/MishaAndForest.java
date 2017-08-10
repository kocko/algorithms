package codeforces.contests501_600.problemset501;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class MishaAndForest implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] degree = new int[n + 1], xor = new int[n + 1];
        boolean[] processed = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            degree[i] = in.ni();
            xor[i] = in.ni();
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        List<String> result = new ArrayList<>();
        while (queue.size() > 0) {
            int idx = queue.poll();
            if (processed[idx]) continue;
            result.add(idx + " " + xor[idx]);
            int next = xor[idx];
            degree[next]--;
            xor[next] ^= idx;
            if (degree[next] == 1) {
                queue.offer(next);
            } else if (degree[next] == 0) {
                processed[next] = true;
            }
        }
        out.println(result.size());
        result.forEach(out::println);
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
        try (MishaAndForest instance = new MishaAndForest()) {
            instance.solve();
        }
    }
}
