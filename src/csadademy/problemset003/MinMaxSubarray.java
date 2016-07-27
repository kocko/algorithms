package csadademy.problemset003;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MinMaxSubarray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            min = Math.min(x[i], min);
            max = Math.max(x[i], max);
        }
        List<Integer> maxs = new ArrayList<>(), mins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (x[i] == min) mins.add(i);
            if (x[i] == max) maxs.add(i);
        }
        int result = 10000;
        for (Integer a : mins) {
            for (Integer b : maxs) {
                result = Math.min(result, Math.abs(a - b));
            }
        }
        out.println(result + 1);
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
        try (MinMaxSubarray instance = new MinMaxSubarray()) {
            instance.solve();
        }
    }
}
