package facebook.hackercup2016.round1;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BoomerangConstellations implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.ni();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.ni(); y[i] = in.ni();
            }
            long result = 0L;
            for (int k = 0; k < n; k++) {
                List<Integer> dist = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (i != k) {
                        int a = x[i] - x[k];
                        int b = y[i] - y[k];
                        dist.add(a * a + b * b);
                    }
                }
                Map<Integer, Long> map = dist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                for (Map.Entry<Integer, Long> entry : map.entrySet()) {
                    long value = entry.getValue();
                    if (value > 1) {
                        result += value * (value - 1) / 2; 
                    }
                }
            }
            out.println("Case #" + testCase + ": " + result);
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
        try (BoomerangConstellations instance = new BoomerangConstellations()) {
            instance.solve();
        }
    }
}
