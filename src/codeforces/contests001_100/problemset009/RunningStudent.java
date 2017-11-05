package codeforces.contests001_100.problemset009;

import java.io.*;
import java.util.StringTokenizer;

public class RunningStudent implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long vb = in.nl(), vs = in.nl();
        long[] x = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = in.nl();
        }
        int ux = in.ni(), uy = in.ni();
        double minDist = Double.POSITIVE_INFINITY;
        double minTime = Double.POSITIVE_INFINITY;
        int result = -1;
        for (int i = 2; i <= n; i++) {
            double dist = Math.sqrt((ux - x[i]) * (ux - x[i]) + (uy * uy));
            double time = x[i] * vs + dist * vb;
            if (time < minTime) {
                minTime = time;
                minDist = dist;
                result = i;
            } else if (time == minTime && dist < minDist) {
                minDist = dist;
                result = i;
            }
        }
        out.println(result);
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
        try (RunningStudent instance = new RunningStudent()) {
            instance.solve();
        }
    }
}
