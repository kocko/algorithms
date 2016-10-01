package codeforces.contests701_800.problemset721;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OneDimensionalJapaneseCrossword implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        List<Integer> list = new ArrayList<>();
        int current = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] == 'B') {
                current++;
            } else {
                if (current != 0) {
                    list.add(current);
                }
                current = 0;
            }
        }
        if (current != 0) {
            list.add(current);
        }
        out.println(list.size());
        for (int i : list) {
            out.print(i + " ");
        }
        out.println();
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
        try (OneDimensionalJapaneseCrossword instance = new OneDimensionalJapaneseCrossword()) {
            instance.solve();
        }
    }
}
