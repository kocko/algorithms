package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Comparator.naturalOrder;

public class KthElement implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int k = in.ni(), n = in.ni();
        long f = in.nl(), a = in.nl(), b = in.nl(), m = in.nl();
        int size = 1 << 16;
        int[] buckets = new int[size];
        long current = f;
        for (int i = 0; i < n; i++) {
            int idx = (int) current >> 16;
            buckets[idx]++;
            current = (current * a + b) % m;
        }
        int bucket = 0;
        while (buckets[bucket] < k) {
            k -= buckets[bucket++];
        }
        long lo = size * bucket, hi = size * (bucket + 1);
        
        buckets = new int[size];
        current = f;
        for (int i = 0; i < n; i++) {
            if (current >= lo && current < hi) {
                buckets[(int) (current - lo)]++;
            }
            current = (current * a + b) % m;
        }
        for (int i = 0; i < size; i++) {
            k -= buckets[i];
            if (k <= 0) {
                out.println(lo + i);
                break;
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
        try (KthElement instance = new KthElement()) {
            instance.solve();
        }
    }
}
