package codeforces.contests901_1000.problemset939;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class ConvenientForEverybody implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[2 * n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
            a[n + i] = a[i];
        }
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + a[i - 1];
        }
        int s = in.ni(), f = in.ni();
        int zones = f - s;
        int bestTime = -1, people = 0;
        for (int time = 1; time <= n; time++) {
            int start = 1;
            if (time > s) {
                start += (n - time);
                start += s;
            } else {
                start = (s - time + 1);
            }
            int end = start + zones - 1;
            if (end > n) end -= n;
            
            int count;
            if (start < end) {
                count = prefix[end] - prefix[start - 1];
            } else {
                count = prefix[end] + prefix[n] - prefix[start - 1];
            }
            if (count > people) {
                bestTime = time;
                people = count;
            }
        }
        out.println(bestTime);
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
        try (ConvenientForEverybody instance = new ConvenientForEverybody()) {
            instance.solve();
        }
    }
}
