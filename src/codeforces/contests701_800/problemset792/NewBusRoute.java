package codeforces.contests701_800.problemset792;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NewBusRoute implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x.add(in.ni());
        }
        Collections.sort(x);
        int min = Integer.MAX_VALUE, count = 1;
        for (int i = 1; i < n; i++) {
            int diff = x.get(i) - x.get(i - 1);
            if (diff < min) {
                min = diff;
                count = 1;
            } else if (diff == min) {
                count++;
            }
        }
        out.println(min + " " + count);
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
        try (NewBusRoute instance = new NewBusRoute()) {
            instance.solve();
        }
    }
}
