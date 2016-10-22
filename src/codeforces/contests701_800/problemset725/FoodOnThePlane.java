package codeforces.contests701_800.problemset725;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FoodOnThePlane implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String x = in.next();
        char seat = x.charAt(x.length() - 1);
        Long row = Long.parseLong(x.substring(0, x.length() - 1));
        long n = ((row - 1) / 4) + 1;
        long result = 16 * (n - 1);
        if (row % 2 == 0) {
            result += 7;
        }
        result += get(seat);
        out.println(result);
    }

    private int get(char c) {
        switch (c) {
            case 'f': return 1;
            case 'e': return 2;
            case 'd': return 3;
            case 'a': return 4;
            case 'b': return 5;
            case 'c': return 6;
        }
        return -1;
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
        try (FoodOnThePlane instance = new FoodOnThePlane()) {
            instance.solve();
        }
    }
}
