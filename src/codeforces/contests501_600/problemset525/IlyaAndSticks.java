package codeforces.contests501_600.problemset525;

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

import static java.lang.Math.*;

public class IlyaAndSticks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Long> sticks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sticks.add(in.nl());
        }
        sticks.sort(Comparator.reverseOrder());
        long result = 0L;
        List<Long> sides = new ArrayList<>();
        for (int i = 0; i < n - 1;) {
            if (abs(sticks.get(i) - sticks.get(i + 1)) <= 1) {
                sides.add(sticks.get(i + 1));
                i += 2;
            } else {
                i++;
            }
        }
        for (int i = 0; i < sides.size() - 1; i += 2) {
            result += sides.get(i) * sides.get(i + 1);
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
        try (IlyaAndSticks instance = new IlyaAndSticks()) {
            instance.solve();
        }
    }
}
