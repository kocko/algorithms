package codeforces.contests901_1000.problemset988;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class EqualSums implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int k = in.ni();
        int[][] arrays = new int[k][];
        Map<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < k; idx++) {
            int n = in.ni();
            int sum = 0;
            arrays[idx] = new int[n];
            for (int i = 0; i < n; i++) {
                arrays[idx][i] = in.ni();
                sum += arrays[idx][i];
            }
            for (int i = 0; i < n; i++) {
                int value = sum - arrays[idx][i];
                if (map.containsKey(value)) {
                    out.println("YES");
                    out.println((idx + 1) + " " + (i + 1));
                    int index = map.get(value);
                    int s = 0;
                    for (int j = 0; j < arrays[index].length; j++) {
                        s += arrays[index][j];
                    }
                    for (int j = 0; j < n; j++) {
                        if (s - arrays[index][j] == value) {
                            out.println((index + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                int value = sum - arrays[idx][i];
                map.put(value, idx);
            }
        }
        out.println("NO");
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
        try (EqualSums instance = new EqualSums()) {
            instance.solve();
        }
    }
}
