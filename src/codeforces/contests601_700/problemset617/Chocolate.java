package codeforces.contests601_700.problemset617;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Chocolate implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        List<Integer> nuts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            if (x[i] == 1) nuts.add(i); 
        }
        if (nuts.size() == 0) {
            out.println(0);
        } else if (nuts.size() == 1) {
            out.println(1);
        } else {
            long result = 1L;
            for (int i = 1; i < nuts.size(); i++) {
                int diff = nuts.get(i) - nuts.get(i - 1);
                result *= diff;
            }
            out.println(result);
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
        try (Chocolate instance = new Chocolate()) {
            instance.solve();
        }
    }
}
