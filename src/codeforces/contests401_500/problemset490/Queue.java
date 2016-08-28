package codeforces.contests401_500.problemset490;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Queue implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Map<Integer, Integer> pair = new HashMap<>();
        Set<Integer> front = new HashSet<>();
        Set<Integer> back = new HashSet<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int x = in.ni(), y = in.ni();
            if (x == 0) {
                result[1] = y;
                back.add(y);
            } else {
                front.add(x);
                back.add(y);
                pair.put(x, y);
            }
        }
        front.removeAll(back);
        result[0] = front.iterator().next();
        int start = result[0], index = 2;
        while (pair.get(start) != null && pair.get(start) != 0) {
            result[index] = pair.get(start);
            index += 2;
            start = pair.get(start);
        }
        index = 3; start = result[1];
        while (pair.get(start) != null && pair.get(start) != 0) {
            result[index] = pair.get(start);
            index += 2;
            start = pair.get(start);
        }
        for (int i : result) {
            out.print(i + " ");
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
        try (Queue instance = new Queue()) {
            instance.solve();
        }
    }
}
