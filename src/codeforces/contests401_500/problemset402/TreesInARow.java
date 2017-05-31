package codeforces.contests401_500.problemset402;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class TreesInARow implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Operation {
        private char type;
        private int idx, height;

        private Operation(char type, int idx, int height) {
            this.type = type;
            this.idx = idx;
            this.height = height;
        }

        @Override
        public String toString() {
            return type + " " + idx + " " + height;
        }
    }
    
    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        List<Operation> result = new ArrayList<>();
        int min = 100000;
        for (int h = 1; h <= 1000; h++) {
            List<Operation> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (x[i] != h + i * k) {
                    if (x[i] > h + i * k) {
                        temp.add(new Operation('-', i + 1, x[i] - h - i * k));
                    } else {
                        temp.add(new Operation('+', i + 1, h + i * k - x[i]));
                    }
                }
            }
            if (temp.size() < min) {
                min = temp.size();
                result = temp;
            }
        }
        out.println(result.size());
        result.forEach(out::println);
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
        try (TreesInARow instance = new TreesInARow()) {
            instance.solve();
        }
    }
}
