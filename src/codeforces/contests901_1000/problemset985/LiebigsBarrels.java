package codeforces.contests901_1000.problemset985;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Collections.sort;

public class LiebigsBarrels implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), l = in.ni();
        List<Long> staves = new ArrayList<>();
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n * k; i++) {
            long next = in.nl();
            staves.add(next);
            if (next < min) {
                min = next;
            }
        }
        sort(staves);
        ArrayDeque<Long> possible = new ArrayDeque<>(), bigger = new ArrayDeque<>();
        for (Long stave : staves) {
            if (stave - l <= min) {
                possible.addLast(stave);
            } else {
                bigger.addLast(stave);
            }
        }
        long result = 0;
        if (possible.size() >= n) {
            int additional = possible.size() - n;
            for (int i = 0; i < n; i++) {
                result += possible.pollFirst();
                int remaining = k - 1;
                if (additional <= remaining) {
                    while (additional-- > 0) {
                        possible.pollFirst();
                        remaining--;
                    }
                } else {
                    while (remaining-- > 0) {
                        possible.pollFirst();
                        additional--;
                    }
                }
                if (bigger.size() < remaining) {
                    remaining -= bigger.size();
                    bigger.clear();
                } else {
                    for (int j = 0; j < remaining; j++) bigger.pollFirst();
                    remaining = 0;
                }
                while (remaining-- > 0) possible.pollFirst();
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
        try (LiebigsBarrels instance = new LiebigsBarrels()) {
            instance.solve();
        }
    }
}
