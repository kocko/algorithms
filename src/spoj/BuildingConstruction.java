package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class BuildingConstruction implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            n = in.ni();
            h = new long[n];
            c = new long[n];
            for (int i = 0; i < n; i++) h[i] = in.nl();
            for (int i = 0; i < n; i++) c[i] = in.nl();
            out.println(minCost());    
        }
    }
    
    private int n;
    private long[] h, c;
    
    private long minCost() {
        int left = 0, right = 10000;
        long result = (long) 1e18;
        while (right - left > 3) {
            int m1 = left  + (right - left) / 3;
            int m2 = right - (right - left) / 3;
            long a = cost(m1), b = cost(m2);
            if (a < b) {
                right = m2;
            } else if (a > b) {
                left = m1;
            } else {
                left = m1;
                right = m2;
            }
        }
        for (int i = left; i <= right; i++) {
            result = min(result, cost(i));
        }
        return result;
    }
    
    private long cost(int height) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (abs(h[i] - height) * c[i]);
        }
        return result;
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
        try (BuildingConstruction instance = new BuildingConstruction()) {
            instance.solve();
        }
    }
}
