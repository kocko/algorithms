package codeforces.contests001_100.problemset091;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Arrays.fill;
import static java.util.Comparator.naturalOrder;

public class Queue implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Walrus implements Comparable<Walrus> {
        private int idx, age;

        private Walrus(int idx, int age) {
            this.idx = idx;
            this.age = age;
        }

        @Override
        public int compareTo(Walrus o) {
            int x = Integer.compare(this.age, o.age);
            return x != 0 ? x : Integer.compare(this.idx, o.idx);
        }
    }

    public void solve() {
        int n = in.ni();
        List<Walrus> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Walrus(i, in.ni()));
        }
        list.sort(naturalOrder());
        int[] result = new int[n];
        int max = -1;
        for (Walrus walrus : list) {
            if (walrus.idx > max) {
                max = walrus.idx;
                result[walrus.idx] = -1;
            } else {
                result[walrus.idx] = max - walrus.idx - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(result[i]);
            out.print(' ');
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
        try (Queue instance = new Queue()) {
            instance.solve();
        }
    }
}
