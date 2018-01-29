package codeforces.contests201_300.problemset222;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class Olympiad implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), x = in.ni();
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        for (int i = 0; i < n; i++) a.add(in.ni());
        for (int i = 0; i < n; i++) b.add(in.ni());
        sort(a);
        sort(b);
        int worst = 0;
        for (int i = 0, j = n; i < n && j > 0; i++) {
            if (a.get(i) + b.get(j - 1) >= x) {
                j--;
                worst++;
            }
        }
        out.println(1 + " " + worst);
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
        try (Olympiad instance = new Olympiad()) {
            instance.solve();
        }
    }
}
