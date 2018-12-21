package codeforces.contests1001_1100.problemset1081;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class FarewellParty implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Map<Integer, List<Integer>> sizes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.ni();
            int size = n - x;
            List<Integer> same = sizes.getOrDefault(size, new ArrayList<>());
            same.add(i);
            sizes.put(size, same);
        }
        boolean possible = true;
        int hat = 1;
        int[] result = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : sizes.entrySet()) {
            int size = entry.getKey();
            List<Integer> indices = entry.getValue();
            possible = indices.size() % size == 0;
            if (possible) {
                for (int i = 0; i < indices.size(); i += size, hat++) {
                    for (int j = i; j < i + size; j++) {
                        result[indices.get(j)] = hat;
                    }
                }
            } else break;
        }
        if (possible) {
            out.println("Possible");
            for (int value : result) {
                out.print(value);
                out.print(' ');
            }
        } else {
            out.println("Impossible");
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
        try (FarewellParty instance = new FarewellParty()) {
            instance.solve();
        }
    }
}
