package hackerrank.contests.statistics;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BasicStatisticsAWarmup implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[] values = new int[n];
        Map<Integer, Integer> occurs = new HashMap<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            values[i] = in.ni();
            total += values[i];
            occurs.put(values[i], occurs.getOrDefault(values[i], 0) + 1);
        }
        Arrays.sort(values);
        double m = (double) total / n;
        double median = (n % 2 == 1) ? values[n / 2] : (values[n / 2 - 1] + values[n / 2]) / 2.0;
        int mode = 0, times = 0;
        for (Map.Entry<Integer, Integer> entry : occurs.entrySet()) {
            if (entry.getValue() > times) {
                mode = entry.getKey();
                times = entry.getValue();
            } else if (entry.getValue() == times) {
                mode = Math.min(mode, entry.getKey());
            }
        }
        double totalDeviation = 0l;
        for (int i = 0; i < n; i++) {
            totalDeviation += (values[i] - m) * (values[i] - m);
        }
        double deviation = Math.sqrt(totalDeviation / n);
        DecimalFormat df = new DecimalFormat("#.#");
        out.println(df.format(m));
        out.println(df.format(median));
        out.println(df.format(mode));
        out.println(df.format(deviation));
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

    public static void main(String[] args) {
        new BasicStatisticsAWarmup().solve();
    }
}
