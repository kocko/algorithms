package codeforces.contests101_200.problemset160;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class FindPair implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), k = in.nl();
        Map<Integer, Long> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = in.ni();
            map.put(value, map.getOrDefault(value, 0L) + 1);
            list.add(value);
        }
        Collections.sort(list);
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            long count = entry.getValue();
            if (k > count * n) {
                k -= n * count;
            } else {
                for (Map.Entry<Integer, Long> entry1 : map.entrySet()) {
                    long c = entry1.getValue();
                    if (k > count * c) {
                        k -= count * c;
                    } else {
                        out.println(entry.getKey() + " " + entry1.getKey());
                        return;
                    }
                }
            }
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
        try (FindPair instance = new FindPair()) {
            instance.solve();
        }
    }
}
