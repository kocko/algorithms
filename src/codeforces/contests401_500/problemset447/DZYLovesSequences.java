package codeforces.contests401_500.problemset447;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class DZYLovesSequences implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        int[] end = new int[n];
        end[0] = 1;
        int last = x[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (x[i] > last) {
                count++;
            } else {
                count = 1;
            }
            last = x[i];
            end[i] = count;
        }
        int[] start = new int[n];
        start[n - 1] = 1;
        last = x[n - 1];
        count = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (x[i] < last) {
                count++;
            } else {
                count = 1;
            }
            last = x[i];
            start[i] = count;
        }
        int max = min(n, 2);
        for (int i = 1; i < n - 1; i++) {
            //we can change x[i] to (x[i - 1] + x[i + 1]) / 2;;
            if (x[i + 1] - x[i - 1] >= 2) {
                int size = 1 + end[i - 1] + start[i + 1];
                if (size > max) max = size;
            }
            if (end[i - 1] + 1 > max) max = end[i - 1] + 1;
            if (start[i + 1] + 1 > max) max = start[i + 1] + 1;
        }
        
        if (end[n - 1] < n) max = max(max, end[n - 1] + 1);
        if (start[0] < n) max = max(max, start[0] + 1);
        
        out.println(max);
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
        try (DZYLovesSequences instance = new DZYLovesSequences()) {
            instance.solve();
        }
    }
}
