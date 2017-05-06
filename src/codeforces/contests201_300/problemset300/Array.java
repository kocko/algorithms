package codeforces.contests201_300.problemset300;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Array implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        List<Integer> plus = new ArrayList<>(), minus = new ArrayList<>(), zero = new ArrayList<>();
        int positive = 0, negative = 0;
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            if (x[i] > 0) positive++;
            else if (x[i] < 0) negative++;
        }
        for (int i = 0; i < n; i++) {
            if (x[i] == 0) zero.add(x[i]);
        }
        if (negative % 2 == 1) {
            for (int i = 0; i < n; i++) {
                if (x[i] < 0) minus.add(x[i]);
            }
        } else {
            int count = 0;
            int i;
            for (i = 0; i < n; i++) {
                if (count == negative - 1) break;
                if (x[i] < 0) {
                    minus.add(x[i]);
                    count++;
                }
            }
            for (; i < n; i++) {
                if (x[i] < 0) {
                    zero.add(x[i]);
                    break;
                }
            }
        }
        if (positive == 0) {
            plus.add(minus.get(0)); minus.remove(0);
            plus.add(minus.get(0)); minus.remove(0);
        } else {
            for (int i = 0; i < n; i++) {
                if (x[i] > 0) plus.add(x[i]);
            }
        }
        print(minus);
        print(plus);
        print(zero);
    }
    
    private void print(List<Integer> list) {
        out.print(list.size());
        out.print(' ');
        out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
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
        try (Array instance = new Array()) {
            instance.solve();
        }
    }
}
