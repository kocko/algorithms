package codeforces.contests1001_1100.problemset1088;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EhabAndA2OperationTask implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), MAX = 1000000;
        for (int i = 1; i <= n; i++) in.ni();
        List<String> operations = new ArrayList<>();
        operations.add(2 + " " + n + " 1");
        operations.add(1 + " " + n + " " + MAX);
        for (int i = 1; i < n; i++) {
            operations.add(2 + " " + i + " " + (MAX - i));
        }
        out.println(operations.size());
        operations.forEach(out::println);
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
        try (EhabAndA2OperationTask instance = new EhabAndA2OperationTask()) {
            instance.solve();
        }
    }
}
